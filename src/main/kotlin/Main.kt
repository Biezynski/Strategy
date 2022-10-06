fun main(args: Array<String>) {


    val employeeCEO = Employee(type = EmployeeType.CEO, strategy = CalculateCEOStrategy())
    println(employeeCEO.calculateNewSalary(100.0,100.0,1.0,2.0))
    val employeeWorker = Employee(type = EmployeeType.Worker, strategy = CalculateWorkerStrategy())
    println(employeeWorker.calculateNewSalary(100.0,100.0,1.0,2.0))
    val employeeSales = Employee(type = EmployeeType.Sales, strategy = CalculateSalesStrategy())
    println(employeeSales.calculateNewSalary(100.0,100.0,1.0,2.0))

}

//TODO type can be deleted
class Employee(private val type: EmployeeType, private val strategy: CalculateStrategy) {

    fun calculateNewSalary(base: Double, sumOfIncomes: Double, employeeIncome: Double, importCalculationFactor:Double): Double{
        return strategy.calculate(base, sumOfIncomes, employeeIncome, importCalculationFactor)
    }
}

enum class EmployeeType {
    CEO, Sales, Worker
}

interface CalculateStrategy{
    fun calculate(base: Double, sumOfIncomes: Double, importCalculationFactor: Double, employeeIncome: Double): Double
}

class CalculateCEOStrategy : CalculateStrategy
{
    override fun calculate(
        base: Double,
        sumOfIncomes: Double,
        importCalculationFactor: Double,
        employeeIncome: Double
    ): Double {
        println("Wyliczam CEO strategy")
        return base + sumOfIncomes * 0.2 + 200 + importCalculationFactor * employeeIncome * 2
    }
}
class CalculateSalesStrategy: CalculateStrategy {

    override fun calculate(
        base: Double,
        sumOfIncomes: Double,
        importCalculationFactor: Double,
        employeeIncome: Double
    ): Double {
        println("Wyliczam SALES strategy")
        return base + sumOfIncomes * 0.01 + importCalculationFactor * employeeIncome
    }
}

class CalculateWorkerStrategy: CalculateStrategy{
    override fun calculate(
        base: Double,
        sumOfIncomes: Double,
        importCalculationFactor: Double,
        employeeIncome: Double
    ): Double {
        println("Wyliczam WORKER strategy")
        return base + employeeIncome * importCalculationFactor
    }
}
