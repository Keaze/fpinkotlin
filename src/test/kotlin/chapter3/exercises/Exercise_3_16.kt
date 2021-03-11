package chapter3.exercises

import chapter3.Cons
import chapter3.List
import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec

// tag::init[]
fun doubleToString(xs: List<Double>): List<String> = foldRightL(xs,
    List.empty()
) {
        x, acc -> Cons(x.toString(), acc)
}
// end::init[]

class Exercise_3_16 : WordSpec({
    "list doubleToString" should {
        "convert every double element to a string" {
            doubleToString(List.of(1.1, 1.2, 1.3, 1.4)) shouldBe
                List.of("1.1", "1.2", "1.3", "1.4")
        }
    }
})
