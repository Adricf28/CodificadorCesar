public class Codificador {
    //ATRIBUTOS
    private String textoOriginal;
    private final char[] alfabeto = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private final char[] alfabetoMayus = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    //CONSTRUCTORES
    public Codificador() {
        textoOriginal = "";
    }

    public Codificador(String textoOriginal) {
        this.textoOriginal = textoOriginal;
    }

    //GETTERS
    public String getTextoOriginal() {
        return textoOriginal;
    }

    //SETTERS
    public void setTextoOriginal(String textoOriginal) {
        this.textoOriginal = textoOriginal;
    }

    //METODOS
    public String codificaDecodifica(int iLlave) {
        char[] textArr = this.textoOriginal.toCharArray();
        char[] alf;
        int index;

        for (int i = 0; i < textArr.length; i++) {
            if (Character.isDigit(textArr[i]) && iLlave > 0) {
                index = Integer.valueOf(textArr[i]);
                for (int j = 0; j < iLlave; j++) {
                    index++;
                    if (index > 57) {
                        index = 48;
                    }
                }
                textArr[i] = (char) index;
            } else if (Character.isDigit(textArr[i]) && iLlave < 0) {
                index = Integer.valueOf(textArr[i]);
                for (int j = 0; j > iLlave; j--) {
                    index--;
                    if (index < 48) {
                        index = 57;
                    }
                }
                textArr[i] = (char) index;
            }
        }

        while (true) {
            if (iLlave > alfabeto.length-1) {
                iLlave -= alfabeto.length;
            } else if (iLlave < 0){
                iLlave += alfabeto.length;
            } else {
                break;
            }
        }

        for (int i = 0; i < textArr.length; i++) {
            for (int j = 0; j < alfabeto.length; j++) {
                if (textArr[i] == alfabeto[j] || textArr[i] == alfabetoMayus[j]) {
                    if (textArr[i] == alfabeto[j]) {
                        alf = alfabeto;
                    } else {
                        alf = alfabetoMayus;
                    }
                    index = j + iLlave;
                    if (!cambio(textArr, alf, i, index) && index > alf.length-1) {
                        cambio(textArr, alf, i, index-alf.length);
                    } else if (!cambio(textArr, alf, i, index) && index < 0) {
                        cambio(textArr, alf, i, index+alf.length);
                    }
                    break;
                }
            }
        }

        return new String(textArr);
    }

    private boolean cambio(char[] arr, char[] alf, int i, int index) {
        try {
            arr[i] = alf[index];
            return true;

        } catch (Exception e) {
            return false;
        }
    }
}