package compresor;

import java.util.ArrayList;
import java.util.List;

public class Paquete {

    public static List<DatosSalidaPaquete> empaquetar(List<DatosIteracionCompresion> listDatosIteracionCompresions) {
        short caracter;
        short constante;

        List<DatosSalidaPaquete> listaPaquetes = new ArrayList<>();
        for (DatosIteracionCompresion dto : listDatosIteracionCompresions) {
            caracter = (short) dto.character();
            constante = (short) (dto.posicion() << 5);
            constante += ((short) dto.repeticiones());
            listaPaquetes.add(new DatosSalidaPaquete(caracter, constante));
        }

        return listaPaquetes;
    }

}
