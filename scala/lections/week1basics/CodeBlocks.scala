package lections.week1basics

object CodeBlocks extends App{
	println("Блок кода (Code block)\n")
	println("val aCodeBlock = {\n\tval someVal = 1\n\tval y = 2\n\n\tif (someVal + y > 1) true else false\n}\nprintln(aCodeBlock) -- выводит true\n")
	println("Блок кода также является выражением, результат(и тип) которого равен результату(и типу) последнего описанного внутри блока кода выражения.")

	println("Если, например, допишем строку \"String to return\" в конец нашего предыдущего блока кода, то aCodeBlock сменит тип на String, что соответствует типу последнего выражения \"String to return\", описанного в блоке\n")
	println("val aCodeBlock = {\n\tval someVal = 1\n\tval y = 2\n\n\tif (someVal + y > 1) true else false\n\t\"String to return\"\n}\nprintln(aCodeBlock) -- выводит \"String to return\"")
	println("Неплохой способ обойтись без return.")

	println("\n! Все, что случилось внутри блока кода, остается внутри блока кода. Т.е. если внутри блока мы определили переменную, которую затем захотели использовать вне этого блока - у нас ничего не выйдет !")


}