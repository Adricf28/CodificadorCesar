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
        int index, numConv=iLlave;

        for (int i = 0; i < textArr.length; i++) {
            if (Character.isDigit(textArr[i]) && numConv > 0) {
                index = Integer.valueOf(textArr[i]);
                for (int j = 0; j < numConv; j++) {
                    index++;
                    if (index > 57) {
                        index = 48;
                    }
                }
                textArr[i] = (char) index;
            } else if (Character.isDigit(textArr[i]) && numConv < 0) {
                index = Integer.valueOf(textArr[i]);
                for (int j = 0; j > numConv; j--) {
                    index--;
                    if (index < 48) {
                        index = 57;
                    }
                }
                textArr[i] = (char) index;
            } else {
                iLlave = ajustar(iLlave, alfabeto.length);
                for (int j = 0; j < alfabeto.length; j++) {
                    if (textArr[i] == alfabeto[j] || textArr[i] == alfabetoMayus[j]) {
                        alf = textArr[i] == alfabeto[j] ? alfabeto : alfabetoMayus;
                        index = j + iLlave;
                        textArr[i] = alf[ajustar(index, alf.length)];
                        break;
                    }
                }
            }
        }

        return new String(textArr);
    }

    private int ajustar(int num, int length) {
        while (num > length-1) {
            num -= length;
        }
        while (num < 0) {
            num += length;
        }
        return num;
    }
}