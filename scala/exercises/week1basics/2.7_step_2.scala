import scala.annotation.tailrec

/*
Потренируемся в работе со строками. 

От вас требуется модифицировать поданную на вход строку так, 
чтобы слова в ней разместились в обратном порядке. Например, строка I like Scala
должна трансформироваться в Scala like I

Как вы уже могли заметить, в результирующей строке слова 
разделены одиночным пробелом, так что не забудьте предусмотреть
удаление всех лишних пробелов из исходной строки. Проверьте, 
чтобы в начале и конце строки пробелов вообще не было.

*/

def smartReverse(sentence: String) : Unit = {
	val myList: List[String] = sentence.split(raw"\s+").toList.reverse
	@tailrec
	def loop(mainList: List[String], i: Int = 0, max: BigInt = myList.length) : Unit = { 
		if (i == max-1) print(mainList.apply(i))
		else {
			print(mainList.apply(i) ++ " ")
			loop(mainList, i+1, max)
		}
	}
	loop(myList)
}

smartReverse(input)


// from others: 
println(input.split(raw"\s+").toList.reverse.mkString(" "))