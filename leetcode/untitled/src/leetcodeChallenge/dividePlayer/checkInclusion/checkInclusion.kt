package leetcodeChallenge.dividePlayer.checkInclusion

import java.lang.StrictMath.pow


class Solution{
    fun checkInclusion(s1 : String, s2 : String) : Boolean{
        if(s1.length < 1 || s2.length > pow(10.0, 4.0)) return false
        if(s1.contains("ABCDEFGHIJKLMNOPQRSTUVWXYZ") || s2.contains("ABCDEFGHIJKLMNOPQRSTUVWXYZ")) return false
        
        var string : String = ""
        var flag = false

        //iterating s2
        for (i in s2.indices){

            if (s2[i] in s1){
                for (j in s1.indices){
                    if (string == ""){
                        string += s2[i]
                        flag = true
                        break
                    }
                    if( flag && s2[i] == s1[j] && !string.contains(s2[i])){
                        string += s2[i]
                        flag = true
                        break
                    }
                    else flag = false
                }
            }
            else{
                flag = false
            }
        }
        return string.length == s1.length
    }
}
fun main(){
    val sol = Solution()
    println(sol.checkInclusion("adc", "dcda"))
}