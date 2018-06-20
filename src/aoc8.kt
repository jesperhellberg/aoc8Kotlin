import java.io.File

fun main(args: Array<String>) {
    val lines = File("input.txt").readLines()
    val register = lines.map{ it.split(" ").first() to 0 }.toMap().toMutableMap()
    val lineList = lines.map { it.split(" ") }
    var maxvalue = 0
    var tempMax = 0

    for (line in lineList) {
        if(evaluateCondition(register[line[4]]!!, line[5], line[6].toInt())) {
            when (line[1]) {
                "inc" -> register[line[0]] = register[line[0]]!! + line[2].toInt()
                "dec" -> register[line[0]] = register[line[0]]!! - line[2].toInt()
            }
        }
        tempMax = register.maxBy { it.value }!!.value
        if(tempMax > maxvalue){ maxvalue = tempMax }
    }
    println("Version 1: $tempMax")
    println("Version 2: $maxvalue")
}


fun evaluateCondition(a: Int, op: String, b: Int): Boolean {
    when (op) {
        ">"     -> return( a > b )
        "<"     -> return( a < b )
        "=="    -> return( a == b )
        "<="    -> return( a <= b )
        ">="    -> return( a >= b )
        "!="    -> return( a != b )
    }
    return false
}