package edu.neu.ccs.cs5004.assignment10;

import java.util.function.Function;

/**
 * Represents a function that takes an integer and returns the lower case
 * english letter combination representation of that integer. The given
 * integer should be greater than 0. Each letter represents a digit represents
 * a value of its index in the English alphabet, (a = 1, b = 2, ... , z = 26).
 * For a letter combination, the letter at the nth position represents a value
 * of its index multiply n - 1 power of the base(26), for example, abc
 * represents 1407(1 * 26^2 + 2 * 26^1 + 3 * 26^0).
 * Created by yanxu on 3/31/17.
 */
class MapToAlphabet implements Function<Integer, String> {

  private String[] alphabet;

  /**
   * Create a new map to alphabet.
   */
  public MapToAlphabet() {
    this.alphabet = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i",
        "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w",
        "x", "y", "z"};
  }

  @Override
  public String apply(Integer integer) {
    String ans = "";
    int temp = integer;
    while (temp > 0) {
      int cur = temp % 26;
      if (cur == 0) {
        cur = 26;
        temp = temp - 26;
      }
      ans = this.alphabet[cur - 1] + ans;
      temp = temp / 26;
    }
    return ans;
  }
}
