package compresor;

// Short porque Byte tiene signo
public record DatosSalidaPaquete(short caracter, short constante) {

    @Override
    public String toString() {
        return caracter + ", " + constante;
    }

}
