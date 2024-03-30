package Ejercicio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class Archivo {
    
    //Metodo para mostrar una ventana 
    //que permita elegir un archivo mediante exploracion
    public static String elegirArchivo(String titulo,
            String textoBoton,
            final String filtro,
            final String descripcionFiltro) {
        //Instanciar el objeto para exploracion del sistema de archivos
        JFileChooser fc = new JFileChooser();
        //Texto del boton aceptar
        fc.setApproveButtonText(textoBoton);
        //Texto del título
        fc.setDialogTitle(titulo);
        if (!filtro.equals("")) {
            //Filtrar archivos por extensión
            fc.addChoosableFileFilter(new javax.swing.filechooser.FileFilter() {
                @Override
                public String getDescription() {
                    return descripcionFiltro;
                }

                @Override
                public boolean accept(File f) {
                    if (f.isDirectory()) {
                        return true;
                    } else {
                        return f.getName().toLowerCase().endsWith(filtro);
                    }
                }
            });
        }
        //Verificar que el usuario eligio un archivo
        if (fc.showOpenDialog(new JFrame()) == JFileChooser.APPROVE_OPTION) {
            //Obtener el archivo seleccionado
            File f = fc.getSelectedFile();
            //retornar el nombre completo del archivo
            return f.getAbsolutePath();
        } else {
            return "";
        }
    }//elegirArchivo
    
    public static BufferedReader abrirArchivo(String nombreArchivo) {
        //Instanciar un objeto para manipular el archivo
        File f = new File(nombreArchivo);
        // Existe el archivo?
        if (f.exists()) {
            // captura de error estructurada: Intenta realizar la instrucción de
            // apertura del archivo. Es susceptible de no poder realizarse
            try {
                // Apertura del archivo plano: 
                // La clase BufferedReader permite manipular secuencias de caracteres. 
                // La clase FileReader permite abrir el archivo para leerlo.
                FileReader fr = new FileReader(f);
                return new BufferedReader(fr);
            } catch (IOException e) {
                // Sucedió un error que se captura mediante la clase IOException
                // encargada de manipular errores de entrada y salida
                return null;
            }
        } else {
            return null;
        }
    }//abrirArchivo
    
    public static String obtenerTextoArchivo(BufferedReader br) {
        String texto = "";
        //Verificar que el archivo fue leido
        if (br != null) {
            try {
                //Leer la primera linea
                String linea = br.readLine();
                while (linea != null) {
                    //Añadir la linea al texto de despliegue
                    texto += linea + "\n";
                    //Leer las siguientes lineas
                    linea = br.readLine();
                }
            } catch (IOException ex) {
            }
        }
        return texto;
    }//obtenerTextoArchivo
    
    public static boolean guardarArchivo(String nombreArchivo, String[] lineas) {
        if (lineas != null) {
            /*
             * captura de error estructurada. Intenta realizar la instrucción de
             * escritura del archivo. Es susceptible de no poder realizarse
             */
            try {
                //Abrir el archivo para escritura
                BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo));
                for (int i = 0; i < lineas.length; i++) {
                    //Guardar cada linea
                    bw.write(lineas[i] + " ");
                    
                }
                //Cerrar el archivo
                bw.close();
                return true;
            } catch (IOException e) {
                /*
                 * Sucedió un error que se captura mediante la clase IOException
                 * encargada de manipular errores de entrada y salida
                 */
                return false;
            }
        } else {
            return false;
        }
    }
    
}
