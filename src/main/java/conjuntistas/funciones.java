package conjuntistas;

public class funciones {
    public funciones() {
    }

    public int doblamiento(int clave, int M) {
        //separa la clave en varios grupos de dígitos y sumarlos entre sí. La suma obtenida es la posición
        //asignada en la tabla.
        int resto = 0, suma = 0;
        int resultado = clave;
        while (resultado != 0) {
            resto = resultado % 1000;
            suma = suma + resto;
            resultado = resultado / 1000;
        }
        if (suma > M) {
            //para ajustarlo a la tabla se tomará el resto del resultado dividido por M
            suma = suma % M;
        }
        return suma;
    }

    public int divNumeroPrimo(int clave, int M){
        int numPrimo = numPrimoMenor(M);
        return clave % numPrimo;
    }

    private int numPrimoMenor(int tamanio){
        //retorna un mayor numero primo menor que tamanio
        int numPrimo = tamanio - 1;
        boolean esNumPrimo = esPrimo(tamanio);
        while (!esNumPrimo){
            numPrimo = numPrimo - 1;
            esNumPrimo = esPrimo(numPrimo);
        }
        return numPrimo;
    }

    private boolean esPrimo(int n) {
        //verifica si el numero n es primo
        boolean numPrimo = true;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                numPrimo = false;
            }
        }
        return numPrimo;
    }


    public int funcionH(String clave, int M) {
        //funcion que retorna la suma de los valores ASCII para cada carácter de la cadena clave
        int suma = 0;
        char[] s = clave.toCharArray();
        for (int i = 0; i < s.length; i++) {
            suma = suma + (int) s[i];
        }
        if (suma > M){
            //para ajustarlo a la tabla se tomará el resto del resultado dividido por M
            suma = suma % M;
        }
        return suma;
    }
}
