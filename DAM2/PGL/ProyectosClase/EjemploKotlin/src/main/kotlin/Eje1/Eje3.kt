import java.util.Scanner

fun main() {
    print("Introduzca un número cualquiera: ");
    var number = getNumber();
    print("¿Desea calcular la suma(1) o el producto(2) de los números?: ");
    do {
        var option = getNumber3();
        var valid = false;
        if (option == 1) {
            showResultSum(number);
            valid = true;
        }
        else if (option == 2) {
            showResultProd(number);
            valid = true;
        }
        else {
            print("[!] No se ha introducido un número válido. Introdúzcalo de nuevo: ");
        }
    } while (!valid);
}

fun getNumber3(): Int {
    val reader = Scanner(System.`in`);
    return reader.nextInt();
}

fun showResultSum(number: Int) {
    print("La suma de los números desde 1 hasta " + number + " es ");
    var sum = 0;
    for (i in 1..number) {
        sum += i;
    }
    print(sum);
}

fun showResultProd(number: Int) {
    print("El producto de los números desde 1 hasta " + number + " es ");
    var prod = 1;
    for (i in 1..number) {
        prod *= i;
    }
    print(prod);
}