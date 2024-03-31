package calculoNomina;

import java.util.ArrayList;

public class Identificadora {
    private int clave;

    public Identificadora(int clave) {
        this.clave = clave;
    }

    public Identificadora buscar(int clave, ArrayList<Identificadora> lista) {
        int i;
        Identificadora dato;
        for (i = 0; i < lista.size(); i++) {
            dato = lista.get(i);
            if (dato.clave == clave) {
                return dato;
            }
        }
        return null;
    }

    public void ordenar(ArrayList<Identificadora> lista) {
        int i, j;
        Identificadora temp;
        for (i = 0; i < lista.size(); i++) {
            for (j = i + 1; j < lista.size(); j++) {
                if (lista.get(i).clave > lista.get(j).clave) {
                    temp = lista.get(i);
                    lista.set(i, lista.get(j));
                    lista.set(j, temp);
                }
            }
        }
    }
}
