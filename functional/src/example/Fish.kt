package example

data class Fish (var name: String)

fun fishExamples() {
    val fish = Fish("splashy") // all lowercase
//    with (fish.name) {
//        println(this.replaceFirstChar {
//            it.uppercaseChar()
//        })
//    }
    myWith (fish.name) {
        // this refer to the string
        println(this.replaceFirstChar {
            it.uppercaseChar()
        })
    }

    val output: String
    fish.run {
        output = this.name
    }
    println(output)

    // apply returns the changed object it was applied to.
    val fish2 = Fish(name = "splashy").apply {
        this.name = "sharky"
    }
    println(fish2.name)

    // let() function is similar to apply() but returns a copy of
    // the object with change, thus can be chained
    // https://developer.android.com/codelabs/kotlin-bootcamp-sams#4
    println("Before the let change ${fish}")
    println(fish.let { it.name.capitalize() } // change the string
        .let{it + "fish"}
        .let{it.length}
        .let{it + 31}
    )
    // fish is a data class
    println(fish)
}

// the class being extended is often called the receiver object
// block is an extension function
fun myWith(name: String, block: String.() -> Unit) {
    name.block()
}

fun runExample() {
    // val runnable = Runnable { println("I'm a Runnable") }
    val runnable = object: Runnable {
        override fun run() {
            println("I'm a Runnable")
        }
    }
    JavaRun.runNow(runnable)
    // pass a lambda to Java SAM
    JavaRun.runNow({
        println("Passing a lambda as a Runnable")
    })
    // use the lambda last parameter call syntax
    // use foo {...} instead of foo({...}) to pass a lambda function
    JavaRun.runNow {
        println("Last parameter is a lambda as a Runnable")
    }
    // Instantiate, override and make a call to a SAM with online of code, using the following pattern: Class.singleAbstractMethod { lambda_of_override}
}


fun main() {
    fishExamples()
    runExample()
}

/*
// how inline reduce the creation of additonal Function object
// https://developer.android.com/codelabs/kotlin-bootcamp-sams#5
inline myWith(fish.name) {
    captialize()
}

// with myWith() inline, this becomes
fish.name.captialize()

// instead of
// actually creates an object that looks like this
myWith(fish.name, object : Function1<String, Unit> {
    override fun invoke(name: String) {
        name.capitalize()
    }
})
*/


