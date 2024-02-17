package lections.week1basics

object StringOperations extends App{

	val aString: String = "Hello, world!"
	println("val aString: String = \"Hello, world!\"\n")

	println("println(aString.length) -- выводит 13")
	println("println(aString.charAt(1)) -- выводит e")
	println("println(aString.substring(0, 2)) -- выводит He")
	println("println(aString.split(\" \").toList) -- выводит List(Hello,, world!)")
	println("println(aString.startsWith(\"He\")) -- выводит true")
	println("println(aString.replace(\"!\", \".\")) -- выводит Hello, world.")
	println("println(aString.toLowerCase) -- выводит hello, world!")
	println("println(aString.toUpperCase) -- выводит HELLO, WORLD!")
	println("println(\"abcd\".reverse) -- выводит dcba")
	println("println(\"abcd\".take(2)) -- выводит ab")

	println(aString.length) // выводит 13
	println(aString.charAt(1)) // выводит e
	println(aString.substring(0, 2)) // выводит He
	println(aString.split(" ").toList) // выводит List(Hello,, world!)
	println(aString.startsWith("He")) // выводит true
	println(aString.replace("!", ".")) // выводит Hello, world.
	println(aString.toLowerCase) // выводит hello, world!
	println(aString.toUpperCase) // выводит HELLO, WORLD!
	println("abcd".reverse) // выводит dcba
	println("abcd".take(2)) // выводит ab

	println("\nМетоды toInt и toString:")
	println("val aNumber = \"42\".toInt")
	val aNumber = "42".toInt
	println(aNumber) // выводит 42
	println(aNumber.getClass) // выводит int

	println("val aStrings = 42.toString")
	val aStrings = 42.toString
	println(aStrings) // выводит 42
	println(aStrings.getClass) // выводит java.lang.String
	println()

	println("Добавление в начало и конец")

	println("println('1' +: \"42\" :+ '3') // выводит 1423\nprintln('a' +: \"bc\" :+ 'd') // abcd\nprintln(\"a\" ++ \"bc\" :++ \"d\") // abcd")
	println("\n1. добавление в начало подразумевает наличие двоеточия после  плюса. Соответственно, добавление в конец - перед плюсом")
	println("2. +: или :+ подразумевает, что присоединять будем одиночные элементы (работаем с типом char)")
	println("3. ++ или :++ указывает, что присоединять будем несколько элементов (используем элементы типа String), следовательно здесь уже понадобятся двойные кавычки")
	println("4. внимание на типы, с которыми работаем: в нашем случае присоединения всегда происходит к элементам типа String (в примере это \"42\" и \"bc\")")
	println("\n! На самом деле +, +: и :+ являются методами !")
	println("Это говорит о том, что +: присоединяет только значения типа Char. Кстати, если переписать код в точечной нотации, получится вот так:\n")
	println("val aStr = \"42\".+:('1')\nprintln(aStr.:+('3'))  // 1423")
	println("\n! println('3' +: '4') -- выводит Error, так как пытаемся скомбиновать значения типа Char, а данная операция предусматривает присоединение только к Vector или Seq !\n\n")


	println("Интерполяция строк:")
	println("Интерполяция применяется, когда в строку необходимо подставить какое-то значение переменной. В целом, из всего списка интерполяторов мы советуем пока обратить внимание всего лишь на два. Причем один интерполятор мы рекомендуем точно запомнить. А об особенности второго просто иметь представление (вдруг попадется на собеседовании).")
	println("\n1 -- s-интерполятор - используется для подставления значения переменной типа String в строку.")
	println("\nval name = \"John\"\nprintln(s\"Hello, $name\") // выводит:")
	var name = "John"
	println(s"Hello, $name") // выводит Hello, John


	println("\nЕсли необходимо вставить выражение, то это выражение указываем в фигурных скобках:")
	println("val name = \"John\"\nval surname = \"Smith\"\nprintln(s\"Hello, ${name + surname}\") // выводит:")
	name = "John"
	val surname = "Smith"
	println(s"Hello, ${name + surname}") // выводит Hello, JohnSmith

	println("\n2 -- raw-интерполятор - Главное, что вам нужно о нем знать, демонстрирует следующий кусок кода (внимание на выдаваемый результат):")
	println("val someString = \"This is \\n a string\"")
	val someString = "This is \n a string"
	println("println(raw\"This is \\n a string\") -- выводит:")
	println(raw"This is \n a string")

	println()

	println("println(raw\"$someString\") -- выводит:")
	println(raw"$someString")
}