/* Вариант 12:
Вычислите среднее значение всех четных элементов списка, находящихся в нечетных местах. */

import util.Random

def averageOfEvenOnOddPositions(list: List[Int]): Option[Double] = {
  list.zipWithIndex //Для использования индексов
    .collect { //Преоброзование списка
      case (elem, index) if index % 2 == 0 && elem % 2 == 0 => elem //Нечетные эелемнеты имеют четный индекс
    } match {
      case Nil => None //Если нет подходящих элементов, возвращаем None
      case filtered=> Some(filtered.sum.toDouble / filtered.size) //Вычисляем среднее значение
  }
}

@main def mapain(): Unit =
  //Генерируем список
  val randList = List.fill(10)(Random.nextInt(100))
  //Поиск среднего
  val average = averageOfEvenOnOddPositions(randList)
  //Вывод
  average match {
  case Some(average) => 
    println(
      s"Average of even elements on odd positions: \u001B[31m$average\u001B[0m from list: \u001B[31m$randList\u001B[0m"
      )
  case None => println("There are \u001B[31mno satisfying items\u001B[0m in the list")
  }