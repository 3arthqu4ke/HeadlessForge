package me.earth.headlessforge.command

/**
 * Splits the given string at whitespaces.
 * By using " sequences containing whitespaces
 * can be escaped.
 *
 * @param msg the message to split.
 * @return the message split at whitespaces.
 */
fun split(msg: String): Array<String> {
    val list = ArrayList<String>()
    var escaped = false
    var builder = StringBuilder()
    for (c in msg) {
        if (c == '"') {
            escaped = !escaped
            if (builder.isNotEmpty()) {
                list.add(builder.toString())
                builder = StringBuilder()
            }
            continue
        } else if (c == ' ' && !escaped) {
            if (builder.isNotEmpty()) {
                list.add(builder.toString())
                builder = StringBuilder()
            }
            continue
        }

        builder.append(c)
    }

    if (builder.isNotEmpty()) {
        list.add(builder.toString())
    }

    return list.toArray(arrayOf())
}

/**
 * @param x the first String.
 * @param y the second String.
 * @return the Levenshtein-Distance between the given Strings.
 */
fun levenshtein(x: String, y: String): Int {
    val dp = Array(x.length + 1) { IntArray(y.length + 1) }
    for (i in 0..x.length) {
        for (j in 0..y.length) {
            when {
                i == 0 -> { dp[i][j] = j }
                j == 0 -> { dp[i][j] = i }
                else -> {
                    dp[i][j] = arrayOf(
                        dp[i - 1][j - 1] + (if (x[i - 1] == y[j - 1]) 0 else 1),
                        dp[i - 1][j] + 1,
                        dp[i][j - 1] + 1).minOrNull()?: Int.MAX_VALUE
                }
            }
        }
    }
    return dp[x.length][y.length]
}