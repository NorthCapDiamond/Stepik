package lections.week1basics

object Functions extends App{
	println("Функции\n")

	println("1. Начинается все с ключевого слова def\n2. За которым следует имя функции\n3. В круглых скобках (при необходимости) указываются параметры и их типы\n4. После скобок ставится двоеточие и конкретизируется тип возвращаемого значения\n5. Наконец - ставится знак равенства и прописывается тело функции\n")
	println("Тело функции вполне можно (и нужно, если того требует логика программы) писать в фигурных скобках (скорее всего, многим так гораздо привычнее) - просто в этом случае дело будем иметь с блоком кода (code block), о котором упоминали ранее.")

	def aPerson(name: String, surname: String): String = {
		s"$name $surname"
	}

	println("def aPerson(name: String, surname: String): String = {\n\ts\"$name $surname\"\n}")
	println("println(aPerson(\"John\", \"Smith\")) -- вернет " + aPerson("John", "Smith"))
	println("Кстати, вполне возможно прописать print в теле самой функции, просто для этого необходимо изменить тип возвращаемого значения на Unit")

	println("Функция без параметров")
	def aNoParams(): Unit = {
		println("No Params on Function... Why not))")
	}

	println("def aNoParams(): Unit = {\n\tprintln(\"No Params on Function... Why not))\")\n}")

	print("Call Function:\naNoParams() выводит: ")
	aNoParams()

	println("\n!Раньше можно было писать без пустых скобок: aNoParams -> 'No Params on Function... Why not)'. Но сейчас это Error: method aNoParams in object Functions must be called with () argument!\n")

	println("Параметры по умолчанию")
	println("В Scala мы можем задавать дефолтные значения для параметров, что позволит нам лишний раз не указывать параметры при вызове функции. Только следите за порядком аргументов.")
	println("def aFunctionWithDefaultParameter(x: Int, y: String = \"Default Parameter\"): String = {\n\ts\"x = $x and y = $y\"\n}")

	def aFunctionWithDefaultParameter(x: Int, y: String = "Default Parameter"): String = {
		s"x = $x and y = $y"
	}

	print("println(aFunctionWithDefaultParameter(1)) -- выводит ")
	println(aFunctionWithDefaultParameter(1))

	println("\nВызов по имени(call-by-name) vs Вызов по значению(call-by-value)")
	def callByValue(x: Long): Unit = {
		println(s"call by value: x1 = $x")
		println(s"call by value: x2 = $x")
	}

	def callByName(x: => Long): Unit = {
		println(s"call by name: x1 = $x")
		println(s"call by name: x2 = $x")
	}

	println("Чтобы увидеть разницу между этими двумя вызовами (кроме того, что рядом с параметром, вызываемым по имени, печатается знак => )давайте поработаем с кодом:")
	println("\ndef callByValue(x: Long): Unit = {\n\tprintln(s\"call by value: x1 = $x\")\n\tprintln(s\"call by value: x2 = $x\")\n}\ndef callByName(x: => Long): Unit = {\n\tprintln(s\"call by name: x1 = $x\")\n\tprintln(s\"call by name: x2 = $x\")\n}")
	callByValue(System.nanoTime())
	callByName(System.nanoTime())

	println("\nЕсли для callByValue на экран выводятся два одинаковых значения, то для callByName значения будут разными.")
	println("\nЭто объясняется разницей в подходах к вычислению значений параметров.\n- Вызов по значению подразумевает вычисление значения переданного выражения перед вызовом функции.\nПреимущество: значение вычисляется только один раз.\n- Вызов по имени подразумевает вычисление значения выражения в момент его вызова в функции\nПреимущество: значение не вычисляется, если не используется в теле функции.\n")
	println("Смотрите: для callByValue мы вычислили значение System.nanoTime() и подставили это значение в функцию. Однако для callByName предварительных вычислений не делалось, и значение высчитывалось уже непосредственно в функции.\n")

	println("Вложенные функции")
	println("Еще одним моментом, который бы хотелось отметить - является возможность определить функцию или даже несколько функций внутри одной функции и там же ее(или их) вызвать.")

	def aBossFunction(): String = {
		def aHelperFunction(): String = "I'm here to help"
		aHelperFunction()
	}
	
	println("def aBossFunction(): String = {\n\tdef aHelperFunction(): String = \"I'm here to help\"\n\taHelperFunction()\n}")
}
