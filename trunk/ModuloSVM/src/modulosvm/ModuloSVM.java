package modulosvm;

import annotations.ClassifierModuleAnnotation;
import annotations.ModuleAnnotation;
import interfaces.HostInterface;
import interfaces.mining.classify.ClassifierModuleInterface;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import smo.Smo;

@ModuleAnnotation(name = "SVM - Suppot Vector Machine")
@ClassifierModuleAnnotation
public class ModuloSVM implements Serializable, ClassifierModuleInterface {

    private JTextArea   jTextArea               = null;
    private transient   JDialog jDialogConfig   = null;
    private transient   HostInterface hostInterface;
    private int         nClasses;
    private Vector      pointsAux               = new Vector();
    private Vector      targetAux               = new Vector();
    private Vector      configurations          = new Vector();

    private double  c                   = 0.05;
    private double  tolerance           = 0.001;
    private double  eps                 = 0.001;
    private double  two_sigma_squared   = 2.0;
    private boolean is_linear_kernel    = true;
    private boolean is_sparse_data      = true;
    private boolean is_binary           = false;
    private boolean is_libsvm_file      = true;
    public  Smo my = new Smo();
   
    public ModuloSVM() {
        FacadeSVM.setModuloSVM(this);
    }

    public JPanel getPainelConfig() {
        return new JPanelSVM();
    }

    public void setJDialogConfig(JDialog jDialogConfig) {
        this.jDialogConfig = jDialogConfig;
    }

    public JDialog getJDialogConfig() {
        return jDialogConfig;
    }

    public void setTextArea(JTextArea jTextArea) {
        this.jTextArea = jTextArea;
    }

    public JPanel getCreatedModel() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setHost(HostInterface hostInterface) {
        this.hostInterface = hostInterface;
    }

    /**
     * Realiza o treinamento
     * @param input - dados das amostras
     * @param output - rotulos das amostras
     */
    public void train(Object[][] input, Object[] output) {
        
        //retira os rotulos
        for(int i = 0; i < output.length; i++){
            targetAux.add(output[i]);
        }

        //retira os dados
        for(int i = 0; i < input.length; i++){

            SparseVector x = new SparseVector();

            for(int j = 0; j < input[i].length; j++){
                x.id.add(j);
                x.val.add(input[i][j]);
            }
            pointsAux.add(x);
        }


        //para todas cada classe, fazer o método um contra todos, encontrar o classificador e armazena-lo
        for(int classeExaminada = 1; classeExaminada <= nClasses; classeExaminada++){

            my.target   = new Vector();
            my.N        = 0;
            String acerto = "";

            //método um contra todos
            //se o rótulo for da classe examinada, rótulo vira 1, e as demais -1
            for(int i = 0; i < input.length; i++){
                
                Float rotulo = Float.parseFloat(targetAux.elementAt(i).toString());

                if(rotulo == classeExaminada){
                    my.target.add(1);
                }else{                   
                    my.target.add(-1);
                }
            }           

            long time, newTime = 0;
            time = System.currentTimeMillis();

            try {

                int numChanged =0;  
                int examineAll =0;  

                my.d                    = input[0].length;
                my.C                    = (float) c;
                my.tolerance            = (float) tolerance;
                my.eps                  = (float) eps;
                my.two_sigma_squared    = (float) two_sigma_squared;
                my.is_linear_kernel     = is_linear_kernel;
                my.is_sparse_data       = is_sparse_data;
                my.is_binary            = is_binary;
                my.is_libsvm_file       = is_libsvm_file;
                my.w = new Vector();
                my.alph = new Vector();

                for(int i = 0; i < input.length; i++){

                    SparseVector x = new SparseVector();

                    for(int j = 0; j < input[i].length; j++){
                        x.id.add(j);
                        x.val.add(input[i][j]);
                    }

                    my.sparse_points.add(x);
                }

                {
                    int n = 0;

                    if (my.N > 0)
                    {
                        my.reserve(my.target, my.N, 1);

                        if (my.is_sparse_data && my.is_binary)
                            my.reserveSparseBinary(my.sparse_binary_points, my.N);
                        else if (my.is_sparse_data && !my.is_binary)
                        {
                            my.reserveSparse(my.sparse_points, my.N);
                        }
                        else
                            my.reserve(my.dense_points, my.N);
                    }
                   
                    n = input.length;

                    my.N                = n;   
                    my.first_test_i     = 0;
                    my.end_support_i    = my.N;
                }
                
                my.resize(my.alph, my.end_support_i, 2);   
                my.b = 0;
                my.resize(my.error_cache, my.N, 2);
                if (my.is_linear_kernel)      
                    my.resize(my.w, my.d, 2);
                if (my.is_linear_kernel && my.is_sparse_data && my.is_binary)
                    my.learned_func_flag = 1;
                if (my.is_linear_kernel && my.is_sparse_data && !my.is_binary)
                    my.learned_func_flag = 2;
                if (my.is_linear_kernel && !my.is_sparse_data)
                    my.learned_func_flag = 3;
                if (!my.is_linear_kernel)         //se nao for kernel linear
                    my.learned_func_flag = 4;

                if (my.is_sparse_data && my.is_binary)
                    my.dot_product_flag = 1;
                if (my.is_sparse_data && !my.is_binary)   //dados esparssos e binarios
                    my.dot_product_flag = 2;
                if (!my.is_sparse_data)
                    my.dot_product_flag = 3;

                if (my.is_linear_kernel)    //se for kernel linear
                    my.kernel_flag = 1;

                if (!my.is_linear_kernel)    //se nao for kernel linear
                    my.kernel_flag = 2;

                if (!my.is_linear_kernel)
                {
                    my.resize(my.precomputed_self_dot_product, my.N, 2);  //muda o tamanho do vetor

                    for (int i = 0; i < my.N; i++)
                        for (int j = 0; j<my.N; j++)
                        {
                            if (i != j)
                                my.precomputed_dot_product[i][j] = my.dot_product_func(i, j, my.dot_product_flag);
                            else
                            {
                                float temp = my.dot_product_func(i, i, my.dot_product_flag);
                                my.precomputed_self_dot_product.set(i, new Float(temp));
                                my.precomputed_dot_product[i][i] = temp;
                            }
                        }
                }

                if (!my.is_test_only)
                {
                    numChanged = 0;  //numero alterado
                    examineAll = 1;  //examinado todos
                    while (numChanged > 0 || examineAll >0)
                    {
                        numChanged = 0;
                        if (examineAll>0)
                        {
                            for (int k = 0; k < my.N; k++)
                                    numChanged += my.examineExample (k);
                        }
                        else
                        {
                            for (int k = 0; k < my.N; k++)
                            {
                                //Se esta escolha falhar em obter um acréscimo significante na função objetivo
                                //dual, o SMO experimenta cada ponto x1 que tenha valores de α diferente dos limites,
                                //ou seja, 0 <α < C , começando aleatoriamente. Se ainda não houver progresso
                                //significativo, o SMO procura por todo o conjunto de dados de treinamento para
                                //encontrar um ponto x1 adequado.
                                //????
                                if (my.object2float(my.alph.elementAt(k)) != 0 && my.object2float(my.alph.elementAt(k)) != my.C)
                                    numChanged += my.examineExample (k);
                            }
                        }
                        if (examineAll == 1)
                            examineAll = 0;
                        else if (numChanged == 0)
                            examineAll = 1;
                        {
                            int non_bound_support =0;
                            int bound_support =0;
                            for (int i=0; i<my.N; i++)
                                if (my.object2float(my.alph.elementAt(i)) > 0)
                                {
                                    if (my.object2float(my.alph.elementAt(i)) < my.C)
                                    {non_bound_support++;}
                                    else
                                        bound_support++;
                                }
                            System.out.println("non_bound= " +non_bound_support+"\t"+"bound_support= "+bound_support);
                            //out.println("non_bound= " +non_bound_support+"\t"+"bound_support= "+bound_support);
                        }
                    }                    

                    {
                        //guarda a configuração
                        ConfigurationSVM config = new ConfigurationSVM();
                        config.setD(                my.d);
                        config.setIs_sparse_data(   my.is_sparse_data);
                        config.setIs_binary(        my.is_binary);
                        config.setIs_linear_kernel( my.is_linear_kernel);
                        config.setIs_libsvm_file(   my.is_libsvm_file);
                        config.setB(                my.b);
                        config.setC(                my.C);
                        config.setEps(              my.eps);
                        config.setTolerance(        my.tolerance);
                        config.setTwo_sigma_squared(my.two_sigma_squared);
                        config.setW(                my.w);
                        config.setAlph(             my.alph);
                        configurations.add(config);
                    }                    

                    System.out.println("Threshold=" + my.b);
                    //out.println("Threshold=" + my.b);
                }

                double erro = my.error_rate();
                System.out.println("Error_rate="+erro);
                System.out.println("Acertou: " +  (1 - erro));
                DecimalFormat form = new DecimalFormat("0.0000");
                acerto = form.format(1 - erro);
                //out.println("Error_rate="+erro);

                newTime = System.currentTimeMillis();
                
                System.out.println("Time cost = "+(newTime - time)*1.0/1000);
                //out.println("Time cost = "+(newTime - time)*1.0/1000);

            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
              
    }    

    /**
     * Realiza o teste
     * @param inputTest - amostra a ser testada
     * @return - a classe que a SVM diz que a amostra é
     */
    public Object test(Object[] inputTest) {      

        double saida[]  = new double[nClasses];
        float learns[]   = new float [nClasses];

        System.out.println("================ entrou no teste ==================");

        //para cada classe existente faça o treino na sua configuração
        for(int classeExaminada = 1; classeExaminada <= nClasses; classeExaminada++){

            long time, newTime = 0;
            time = System.currentTimeMillis();

            //retira a configuração da classe examinada
            ConfigurationSVM config = (ConfigurationSVM) configurations.get(classeExaminada-1);
            my = new Smo();
            my.is_test_only         = true;
            my.d                    = config.getD();
            my.is_sparse_data       = config.isIs_sparse_data();
            my.is_binary            = config.isIs_binary();
            my.is_linear_kernel     = config.isIs_linear_kernel();
            my.is_libsvm_file       = config.isIs_libsvm_file();
            my.b                    = config.getB();
            my.C                    = config.getC();
            my.eps                  = config.getEps();
            my.tolerance            = config.getTolerance();
            my.two_sigma_squared    = config.getTwo_sigma_squared();
            my.w                    = config.getW();
            my.alph                 = config.getAlph();


            {
                int n = 0;
                if (my.is_test_only)
                {
                    try
                    {
                        my.sparse_points = new Vector();
                        SparseVector x = new SparseVector();
                            for(int i = 0; i < inputTest.length; i++){
                                x.id.add(i);
                                x.val.add(inputTest[i]);
                            }
                            my.sparse_points.add(x);

                            my.end_support_i = my.first_test_i = n = 1;
                            // my.N += n;
                    }
                    catch (Exception e)
                    {
                            e.printStackTrace();
                    }
                }

                if (my.N > 0)
                {
                    my.reserve(my.target,my.N,1);

                    if (my.is_sparse_data && my.is_binary)
                        my.reserveSparseBinary(my.sparse_binary_points,my.N);
                    else if (my.is_sparse_data && !my.is_binary)
                    {
                        my.reserveSparse(my.sparse_points,my.N);

                    }
                    else
                        my.reserve(my.dense_points,my.N);
                }

                n = 1;

                if (my.is_test_only)
                {
                    my.N = my.first_test_i + n;
                }
                else
                {
                    my.N                = n;
                    my.first_test_i     = 0;
                    my.end_support_i    = my.N;
                }
            }

            if (my.is_linear_kernel && my.is_sparse_data && my.is_binary)
                my.learned_func_flag = 1;
            if (my.is_linear_kernel && my.is_sparse_data && !my.is_binary)
                my.learned_func_flag = 2;
            if (my.is_linear_kernel && !my.is_sparse_data)
                my.learned_func_flag = 3;
            if (!my.is_linear_kernel)         //se nao for kernel linear
                my.learned_func_flag = 4;

            if (my.is_sparse_data && my.is_binary)
                my.dot_product_flag = 1;
            if (my.is_sparse_data && !my.is_binary)
                my.dot_product_flag = 2;
            if (!my.is_sparse_data)
                my.dot_product_flag = 3;

            if (my.is_linear_kernel)
                my.kernel_flag = 1;

            if (!my.is_linear_kernel)
                my.kernel_flag = 2;

            if (!my.is_linear_kernel)
            {
                my.resize(my.precomputed_self_dot_product,my.N,2);

                for (int i=0; i<my.N; i++){
                    for (int j=0; j<my.N; j++){
                        if (i != j)
                            my.precomputed_dot_product[i][j] = my.dot_product_func(i,j,my.dot_product_flag);
                        else
                        {
                            float temp = my.dot_product_func(i,i,my.dot_product_flag);
                            my.precomputed_self_dot_product.set(i,new Float(temp));
                            my.precomputed_dot_product[i][i] =temp;
                        }
                    }
                }
            }

            HashMap retorno = my.error_rate2();
            int erro = Integer.parseInt(    retorno.get("saida").toString());
            float learn = Float.parseFloat( retorno.get("learn").toString());

            newTime = System.currentTimeMillis();

            System.out.println("Time cost = "+(newTime - time)*1.0/1000);
//          out.println("Time cost = "+(newTime - time)*1.0/1000);

            for(int k = 0; k < inputTest.length ; k++)
                System.out.println(inputTest[k]);
            System.out.println(erro);

            saida[classeExaminada - 1] = erro;
            learns[classeExaminada -1] = learn;
        }

        //verifica entre todas as saidas, qual é a certa pra retornar
        for(int i = 0; i < saida.length; i++){
            if((saida[i] == 1.0) && outrasSaoDiferentesDaI(i, saida)){                
                return i+1;
            }else{                
                return maiorValor(learns);
            }
        }
        
        return null;
    }

    /**
     * Retorna a posicao do maior valor dos learns
     * @return posicao
     */
    public int maiorValor(float learns[]){       

        float max = -Float.MAX_VALUE;        
        int posicao = -1;

        for(int i = 0; i < learns.length; i++){

            if(learns[i] > max){
                max = learns[i];
                posicao = i;
            }
        }

        return posicao + 1;
    }

    /**
     * Verifica se as outras saidas são diferentes da i
     * @param i
     * @param saida
     * @return
     */
    public boolean outrasSaoDiferentesDaI(int i, double saida[]){

        for(int j = 0; j < saida.length; j++){

            if(j != i){
                if(saida[i] == saida[j])
                    return false;
            }
        }
        return true;
    }

    public ClassifierModuleInterface clone(){
        try {
            return (ClassifierModuleInterface) super.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(ModuloSVM.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void createInstanceClissify(String[] attributes, Collection classes) {
        
        jTextArea.append(" Support Vector Machine - SVM");
        nClasses = classes.size();
    }

    public JTextArea getJTextArea() {
        return jTextArea;
    }

    /**
     * @return the tolerance
     */
    public double getTolerance() {
        return tolerance;
    }

    /**
     * @param tolerance the tolerance to set
     */
    public void setTolerance(double tolerance) {
        this.tolerance = tolerance;
    }

    /**
     * @return the eps
     */
    public double getEps() {
        return eps;
    }

    /**
     * @param eps the eps to set
     */
    public void setEps(double eps) {
        this.eps = eps;
    }

    /**
     * @return the two_sigma_squared
     */
    public double getTwo_sigma_squared() {
        return two_sigma_squared;
    }

    /**
     * @param two_sigma_squared the two_sigma_squared to set
     */
    public void setTwo_sigma_squared(double two_sigma_squared) {
        this.two_sigma_squared = two_sigma_squared;
    }

    /**
     * @return the is_linear_kernel
     */
    public boolean getIs_linear_kernel() {
        return is_linear_kernel;
    }

    /**
     * @param is_linear_kernel the is_linear_kernel to set
     */
    public void setIs_linear_kernel(boolean is_linear_kernel) {
        this.is_linear_kernel = is_linear_kernel;
    }

    /**
     * @return the is_sparse_data
     */
    public boolean getIs_sparse_data() {
        return is_sparse_data;
    }

    /**
     * @param is_sparse_data the is_sparse_data to set
     */
    public void setIs_sparse_data(boolean is_sparse_data) {
        this.is_sparse_data = is_sparse_data;
    }

    /**
     * @return the is_binary
     */
    public boolean getIs_binary() {
        return is_binary;
    }

    /**
     * @param is_binary the is_binary to set
     */
    public void setIs_binary(boolean is_binary) {
        this.is_binary = is_binary;
    }

    /**
     * @return the c
     */
    public double getC() {
        return c;
    }

    /**
     * @param c the c to set
     */
    public void setC(double c) {
        this.c = c;
    }

}
