package chapter3.exercises

import chapter3.Cons
import chapter3.List
import chapter3.List.Companion.empty
import chapter3.Nil
import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec

// tag::init[]
fun <A> filter2(xa: List<A>, f: (A) -> Boolean): List<A> =
    flatMap(xa){ x: A -> if(f(x)) { Cons(x, Nil) } else { empty<A>() } }
// end::init[]

class Exercise_3_20 : WordSpec({
    "list filter" should {
        "filter out elements not compliant to predicate" {
            filter2(
                List.of(1, 2, 3, 4, 5)
            ) { it % 2 == 0 } shouldBe List.of(2, 4)
        }
    }
})
