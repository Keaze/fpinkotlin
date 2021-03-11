package chapter3.exercises

import chapter3.Cons
import chapter3.List
import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec

// tag::init[]
fun <A> filter(xs: List<A>, f: (A) -> Boolean): List<A> = foldRightL(xs,
    List.empty()
) {
        x, acc -> if(f(x)) {
    Cons(x, acc)
} else { acc }
}
// end::init[]

class Exercise_3_18 : WordSpec({
    "list filter" should {
        "filter out elements not compliant to predicate" {
            val xs = List.of(1, 2, 3, 4, 5)
            filter(xs) { it % 2 == 0 } shouldBe List.of(2, 4)
        }
    }
})
