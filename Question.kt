package org.geeksforgeeks.quizapp
class Question(
    // answerResId will store question
    var answerResId: Int,
  
    // answerTrue will store correct answer
    // of the question provided
    var answerTrue: Boolean
) {
    // Returning the question passed
    fun getAnswerResId(): Int {
        return answerResId
    }

    // Setting the question passed
    fun setAnswerResId(answerResId: Int) {
        this.answerResId = answerResId
    }

    // Returning the correct answer of the question
    fun isAnswerTrue(): Boolean {
        return answerTrue
    }

    // Setting the correct answer of the question
    fun setAnswerTrue(answerTrue: Boolean) {
        this.answerTrue = answerTrue
    }
}
