package lections.week1basics

import scala.annotation.tailrec

object Recursion extends App { 
	println("Циклы")
	println("Начнем мы подбираться к рекурсии со стороны циклов. В Scala они есть - куда уж без них. И вполне себе работают.")
	println("Например, вот таким while-циклом мы можем напечатать слово n раз.\n")

	println("var i = 0\nwhile (i < 3) {\n\tprintln(\"hello\")\n\ti += 1\n}")
	println("Вот только делать так не надо. Просто знайте - так делать можно, но не надо  Особенно если хотите мастерски владеть функциональным программированием.\n")
	println("Мы и for вам пока рекомендуем оставить в стороне. Почему? А все потому, что возникает необходимость использовать var переменные - а мы в функциональном программировании в этом не заинтересованы, т.к. работаем с неизменяемыми переменными - т.е. с val.\n")

	println("Рекурсия")
	print("def factorial(n: Int): Int = {\n\tif (n <= 0) 1\n\telse n * factorial(n - 1)\n}\nprintln(factorial(3)) -- выводит ")
	def factorial(n: Int): Int = {
		if (n <= 0) 1
		else n * factorial(n - 1)
	}

	println(factorial(3)) // выводит 6


	println("\nПодробнее:\n")
	def factorialDescriptional(n : Int): Int = {
		if(n <= 0){
			println("Имеем n = 0, условие выхода из рекурсии")
			1
		}
		else {
			println("Имеем n = " ++ n.toString)
			println(s"Считаем factorial для n-1 = ${n-1}")
			val res = n*factorialDescriptional(n-1)
			println(s"Вычислили факториал $n, его значение $res")

			res
		}
	}

	println(s"Answer = ${factorialDescriptional(3)}\n")

	println("Получается, что у нас хранятся все вызовы к стеку - а это имеет свои ограничения по памяти. Как следствие - StackOverflowError при задании довольно большого числа, для которого надо посчитать факториал.\n")

	println("Хвостовая рекурсия (Tail Recursion)")
	println("Хвостовая рекурсия - это именно то, что применяется при работе с большими данными. Эдакая функциональная форма циклов. Поэтому настоятельно рекомендуем как следует в ней разобраться.")
	println("Переписанный код с применением хвостовой рекурсии выглядит следующим образом:")
	println("def tailRecursion(n : Int) : Int = {\n\tdef loop(x: Int, accumulator: Int) : Int = {\n\t\tif (x <= 1) accumulator\n\t\telse loop(x-1, accumulator*x)\n\t}\n\tloop(n, 1)\n}")
	def tailRecursion(n : Int) : Int = { 
		println("Enter tailRecursion")
		@tailrec
		def loop(x: Int, accumulator: Int) : Int = { 
			println(s"Enter loop with x = $x, accumulator = $accumulator")
			if (x <= 1){ 
				println("x <= 1, условие выхода из рекурсии")
				accumulator
			}
			else{ 
				println(s"Считаем факториал для x-1 = ${x-1}")
				loop(x-1, accumulator*x)
			}
		}
		loop(n, 1)
	}

	println("\nПодробнее\n")
	println(s"Answer = ${tailRecursion(3)}")
	println("!По уже сложившейся традиции - такие функции принято называть loop или go!\n\n")


	println("Как писать функции в стиле хвостовой рекурсии?")

	println("1. Определяете функцию. Назовем ее основной.\n2. Внутри основной функции прописываете еще одну функцию. Назовем ее вспомогательной.\n3. В качестве аргументов вспомогательной функции указываете число вызовов (этот аргумент совпадает с одним из аргументов основной функции) - плюс аккумулятор, который будет содержать конечный результат.\n4. Прописываете код с рекурсией в теле вспомогательной функции с использованием аккумулятора (так, чтобы значение постепенно накапливалось)\n5. Вызываете вспомогательную функцию из основной функции. Не забудьте указать начальное значение аккумулятора, задающее отправную точку всех вычислений. Используйте аргумент по умолчанию для оптимизации кода.\n\nКак проверить функцию на предмет хвостовой рекурсии")
	println("Если вы не уверены, действительно ли вы имплементировали хвостовую рекурсию - можете воспользоваться аннотацией @tailrec. Этим вы укажете компилятору, что функция должна быть tail recursive, и если это не так, ваш код просто не запустится.")
	println("Просто импортируйте import scala.annotation.tailrec, а сам  @tailrec пропишите перед рекурсивной функцией:")
	println("def factorialWithTailRecursion(n: Int): Int = {\n\t@tailrec\n\tdef loop(x: Int, accumulator: Int = 1): Int = ...\n")
	println("Кстати, вы не забыли про возможность использовать значения по умолчанию? Любое вычисление факториала начинается с 1 - что мы и отразили в коде,  использовав значение по умолчанию.")
	println("Вывод слова n раз")

	print("def nTimesWord(n : Int, word : String) : String = {\n\t@tailrec\n\tdef loop(i : Int, acc : String = word) : String = {\n\t\tif (i<=1) acc else loop(i-1, s\"$acc $word\")\n\t}\n\tloop(n)\n}\nprintln(nTimesWord(5, \"Hello\"))\nAnswer : ")

	def nTimesWord(n : Int, word : String) : String = {
		@tailrec
		def loop(i : Int, acc : String = word) : String = {
			if (i<=1) acc else loop(i-1, s"$acc $word")
		}
		loop(n)
	}

	println(nTimesWord(5, "Hello"))
}