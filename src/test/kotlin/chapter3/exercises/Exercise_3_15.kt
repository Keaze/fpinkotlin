package chapter3.exercises

import chapter3.Cons
import chapter3.List
import chapter3.List.Companion.empty
import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec

// tag::init[]
fun increment(xs: List<Int>): List<Int> = foldRightL(xs, empty()) {
    x, acc -> Cons(x + 1, acc)
}
// end::init[]

class Exercise_3_15 : WordSpec({
    "list increment" should {
        "add 1 to every element" {
            increment(List.of(1, 2, 3, 4, 5)) shouldBe
                List.of(2, 3, 4, 5, 6)
        }
    }
})
