package chapter5.exercises

import chapter3.Cons
import chapter3.List
import chapter3.List.Companion.empty
import chapter5.Boilerplate.foldRight
import chapter5.Stream
import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec

/**
 * Re-enable the tests by removing the `!` prefix!
 */
class Exercise_5_1 : WordSpec({
    //tag::init[]
    fun <A> Stream<A>.toList(): List<A> =
        this.foldRight({ empty() }){ a, b -> Cons(a, b()) }
    //end::init[]

    "Stream.toList" should {
        "force the stream into an evaluated list" {
            val s = Stream.of(1, 2, 3, 4, 5)
            s.toList() shouldBe List.of(1, 2, 3, 4, 5)
        }
    }
})
