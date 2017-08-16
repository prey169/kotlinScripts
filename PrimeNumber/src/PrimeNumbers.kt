package primeNumber

fun isPrime(num: Int): Int {
    if (num > 1){
        if (num == 2) return 1
        if (num % 2 == 0) return 0
        for (i in 3 until (num /2) step 2){
            if (num % i == 0) {
                return 0
            }
        }
        return 1
    }
    return -1
}

fun lowPrime(num: Int): Int {
    for (i in num.downTo(2)) {
        var prime: Int = isPrime(i)

        if (prime == 1) {
            return i
        }
    }
    return 1
}

fun highPrime(num: Int): Int {
    var i: Int = num

    do {
        i++
        var prime: Int = isPrime(i)
    }while (prime == 0)

    return i
}

fun getNum(): Int {
    var match: Boolean? = true
    var num: Int = 0
    val regex = Regex(".* +.*|.*\\D+.*|.*\\W+.*|")

    while (match == true || num <= 0 || num > Int.MAX_VALUE){
        println("Enter an integer to see of it is prime:")
        var uinput = readLine()
        match = uinput?.matches(regex)

        if (match == true || uinput?.matches(Regex("^\\d\\d?\\d?\\d?\\d?\\d?\\d?\\d?\\d?\\d?")) == false){
            num = 0
        } else {
            num = uinput!!.toInt()
        }
    }
    return num
}


fun main(args: Array<String>) {
    val num = getNum()
    var prime = isPrime(num)

    when (prime) {
        1 -> println("$num is prime.")
        -1 -> println("$num is less then 2")
        else -> {
            val low = lowPrime(num)
            val high = highPrime(num)
            println("Closest prime numbers:")
            println("${low} < ${num} < ${high}")
        }
    }
    /*
    if (prime == 1){
        println("$num is prime.")
    }
    else {
        val low = lowPrime(num)
        val high = highPrime(num)
        println("Closest prime numbers:")
        println("$low < $num < $high")
    }
     */
}