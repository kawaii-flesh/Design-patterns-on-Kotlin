enum class Material
{
    Steel,
    Silver,
    Gold
}

abstract class Fork(val material: Material)
abstract class Spoon(val material: Material)
abstract class Knife(val material: Material)

interface ISetsOfCutleryFabric
{
    fun createFork(): Fork
    fun createSpoon(): Spoon
    fun createKnife(): Knife
}

class SteelCutlery: ISetsOfCutleryFabric
{
    class SteelFork: Fork(Material.Steel)
    class SteelSpoon: Spoon(Material.Steel)
    class SteelKnife: Knife(Material.Steel)

    override fun createFork(): Fork = SteelFork()
    override fun createSpoon(): Spoon = SteelSpoon()
    override fun createKnife(): Knife = SteelKnife()
}

class GoldCutlery: ISetsOfCutleryFabric
{
    class GoldFork: Fork(Material.Gold)
    class GoldSpoon: Spoon(Material.Gold)
    class GoldKnife: Knife(Material.Gold)

    override fun createFork(): Fork = GoldFork()
    override fun createSpoon(): Spoon = GoldSpoon()
    override fun createKnife(): Knife = GoldKnife()
}

class Table
{
    fun layTheTable(fabric: ISetsOfCutleryFabric)
    {
        fabric.createFork()
        fabric.createSpoon()
        fabric.createKnife()
    }
}

fun main()
{
    val table = Table()
    val fabric = GoldCutlery()
    
    table.layTheTable(fabric)
}