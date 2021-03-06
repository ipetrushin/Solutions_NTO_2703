# Решения предметного тура информатики НТО (27 марта)

## Задача 1. Инверсия клеток
Создаём двумерный массив (или вложенный список), заполняем нулями (0). Считываем координаты нажимаемых клеток, получаем номер столбца и строки, инвертируем все клетки строки и столбца (можно в одном цикле, т.к. поле квадратное).

## Задача 2. Инверсия клеток наоборот
Порядок нажатия клеток значения не имеет, в чём легко убедится. Повторно нажимать клетку смысла нет, так что всего возможных комбинаций для нажатий = 2^N. Для небольших полей возможен и полный перебор, однако обратим внимание на сумму клеток по столбцу и строке для выбранной клетки. При нажатии сумма меняется с чётной на нечётную и обратно. Достаточно для каждого поля посчитать таким образом сумму, клетки с нечётной суммой были нажаты.

## Задача 3. Ливень
Можно решать разными способами, например, рекурсивно. Находим самую высокую вершину, разделяем поле надвое (или на бОльшее число частей,  если есть вершины одинаковой высоты). Для каждой части продолжаем аналогичную операцию, пока не встретим на противоположной стороне вершину, после чего останется только посчитать площать образовавшегося водоёма: число столбцов и разницу высоты каждого с высотой найденной вершины. После окончания рекурсии для всех частей поля просуммировать площать водоёмов.

## Задача 4. Вещества
Для реакции заданы исходные вещества и её продукты. В цикле определяем для каждой реакции, возможна ли она. Если да, пополняем список имеющихся веществ продуктами реакции (удобно использовать множество) и удаляем реакцию из списка. Повторяем цикл до тех пор, пока не перестанут появляться новые вещества. 

## Задача 5. Затопленный лабиринт
По условию весь лабиринт оказался затоплен. Исходные данные таковы, что полостей нет, так что все клетки обозначенные пустыми отмечаем заполненными водой. Затем рекурсивно начинаем освобождать клетки с нижних выходов лабиринта, двигаясь по "воде" только вверх, влево или вправо. После окончания обхода заполенными остаются только те клетки, в которые можно было попасть сверху вниз, остаётся только их посчитать. 
