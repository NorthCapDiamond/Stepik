import scala.annotation.tailrec

/*

Попрактикуемся еще, чтобы уж точно набить руку.

От вас требуется написать программу, которая:

увеличивает заданное число x на число y n-ое количество раз
выводит на экран полученное на шаге 1 число столько раз, сколько в нем цифр, 
и фразу is the result
Замечания:

в этот раз имплементация принта конечного результата на вас
давайте ограничимся целыми числами Int
обратиться к входным аргументам (они уже заданы и доступны для использования)
можно через fArgs(0), fArgs(1) и fArgs(2), что соответствует x, y и n 
(не забудьте вызвать написанную вами функцию, передав ей на вход требуемые аргументы)
прописывать def main(args: Array[String]) не надо - это сделано за вас, можете сразу 
начинать писать свой код к заданию
постарайтесь обойтись без использования var и циклов while, 
данную программу можно и нужно написать, используя только хвостовую рекурсию,
ведь именно ее мы отрабатываем


Sample Input:
10 1 5

Sample Output:
15 15 is the result

*/

def summer(n: BigInt, p: BigInt, t: BigInt) : Unit = {
	@tailrec
	def loop(x: BigInt = n, m: BigInt = p, times: BigInt = t) : BigInt = { 
		if (times == 0) x
		else loop(x + m, m, times - 1)
	}

	val answer = loop()
	@tailrec
	def loop2(amount: BigInt = answer.toString.length - 1, accum: String = answer.toString) : String = { 
		if(amount == 0) accum
		else loop2(amount-1, s"$accum ${answer.toString}")
	}

	println(loop2()++" is the result")
}
//summer(fArgs(0), fArgs(1), fArgs(2))



