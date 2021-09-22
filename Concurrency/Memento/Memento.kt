abstract class Memento(val id: String)

interface IStorable
{
    fun getMemento(id: String): Memento
    fun load(memento: Memento)
}

class A(name: String, someProperty: Double): IStorable
{    
    var name: String = name
    private set
    var someProperty: Double = someProperty
    private set
    private var state: Boolean = false
    fun invertState(){state = !state}
    
    override fun getMemento(id: String) = AMemento(id)
    override fun load(memento: Memento)
    {
        if(memento is AMemento)
        {
            name = memento.name
            someProperty = memento.someProperty
            state = memento.state
        }
    }

    inner class AMemento(id: String): Memento(id)
    {
        val name = this@A.name        
        val someProperty = this@A.someProperty
        val state = this@A.state
    }
}

fun main()
{
    val a = A("name", 13.37)
    val memento = a.getMemento("1234")
    a.invertState()
    a.load(memento)
}