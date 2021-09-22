class DBManager private constructor()
{
    companion object
    {        
        var instance: DBManager? = null
        get()
        {
            if(instance == null)
                instance = DBManager()
            return instance
        }
        private set
    }
    fun doSomeStuff(){}
}

fun main()
{
    val DBManagerInstance = DBManager.instance
}