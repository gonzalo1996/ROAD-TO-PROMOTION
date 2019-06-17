package files;


import java.io.*;

/**
 * Clase encargada de Lectura y/o Escritura de objetos, con sus correspondientes rutas.
 */
public class IOGenericFile {

    /**
     * Escribe un objeto en un archivo.
     * @param file direcciÃ³n del archivo contenedor.
     * @param <T> objeto que implementa la interfaz serializable.
     * @example
     */
    public static <T extends Serializable> void escribirObjeto(T t, String file) {

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {

            out.writeObject(t);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Lee un archivo.
     * @param file direcciÃ³n del archivo contenedor.
     * @return devuelve un objeto T de lo que se guardÃ³ en el archivo.
     */
    @SuppressWarnings("unchecked")
    public static <T extends Serializable> T leerObjeto(String file) {

        T t = null;

        try (ObjectInputStream in = new ObjectInputStream( new FileInputStream(file) )) {

            t = (T) in.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No existe objeto correspondiente.");
        }
        return t;
    }

}
