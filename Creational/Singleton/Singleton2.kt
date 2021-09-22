class DBManager private constructor()
{
    companion object
    {        
        val instance: DBManager by lazy {DBManager()}
    }
    fun doSomeStuff(){}
}

fun main()
{
    val DBManagerInstance = DBManager.instance
}