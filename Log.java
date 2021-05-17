import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.io.File;
import java.util.Date;
 public class Log {
    private static String nombreArchivo = null;
    File file;
    FileWriter fw ;    
    Date fecha;
    public Log() {
        fecha = new Date();
    }
    /**
     * @param linea
     * @throws IOException
     */
    public static void logFile(String linea) throws IOException {
        String fecha = new SimpleDateFormat("[dd MM yyyy HH mm ss]").format(new Date());
        if (nombreArchivo == null) {
            nombreArchivo = fecha;
                
        }
        try {
            File file = new File(nombreArchivo+ "-log" + ".txt");
        
        FileWriter fw = new FileWriter(file, true);
        fw.write(fecha + " " + linea + "\n");
        fw.flush();
        fw.close();
        } catch (IOException ex) {
            System.out.println(ex + "Directorio no encontrado");
        }
    }
}
