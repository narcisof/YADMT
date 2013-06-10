package model;

import java.lang.reflect.Constructor;

public class ModuleAvailable<T> {

    /**
     * module name
     */
    private String name;

    /**
     *constructor name
     */
    private Constructor<T> constructor;

    /**
     * default constructor
     */
    public ModuleAvailable() {
    }

    /**
     * returns the constructor
     * @return constructor
     */
    public Constructor<T> getConstructor() {
        return constructor;
    }

    /**
     * sets the constructor
     * @param constructor
     */
    public void setConstructor(Constructor<T> constructor) {
        this.constructor = constructor;
    }

    /**
     * returns the module name
     * @return name - module name
     */
    public String getName() {
        return name;
    }

    /**
     * sets the module name
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
