package compresor;

public record DatosIteracionCompresion(char character, int posicion, int repeticiones) {

    @Override
    public String toString() {
        return "DatosIteracionCompresion{" + "character=" + character + ", posicion=" + posicion + ", repeticiones=" + repeticiones + '}';
    }

}
