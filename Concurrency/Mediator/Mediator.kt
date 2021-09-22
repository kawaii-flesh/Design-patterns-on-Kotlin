class Mediator(private val a: A)
{   
    fun changeTextA(text: String)
    {
        if(a.state == true)
        {
            a.text = text
            invertStateA()
        }
    }
    fun invertStateA(){a.state = !a.state}
}

class A
{
    var state: Boolean = false
    var text: String = ""
}

class B(val mediator: Mediator)
{
    fun changeTextA(text: String) = mediator.changeTextA(text)
}

class C(val mediator: Mediator)
{
    fun invertStateA(){mediator.invertStateA()}
}

fun main()
{
    val a: A = A()
    val mediator = Mediator(a)

    val b: B = B(mediator)
    val c: C = C(mediator)

    c.invertStateA()
    b.changeTextA("Hello")
}