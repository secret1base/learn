package leetcode;

/**
 * 459. 重复的子字符串
 * @author: wyj
 * @date: 2021/06/29
 */
public class A459_DuplicateSubstring {
    /**
     * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
     *  示例 1:
     * 输入: "abab"
     * 输出: True
     * 解释: 可由子字符串 "ab" 重复两次构成。
     *  示例 2:
     * 输入: "aba"
     * 输出: False
     *  示例 3:
     * 输入: "abcabcabcabc"
     * 输出: True
     * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
     *
     * 解题思路重点在于:abcabcabcabc可以由abcabc两次构成，这样这个字符串肯定是从大到小进行判断更快
     * 			执行耗时:21 ms,击败了57.26% 的Java用户
     * 			内存消耗:38.8 MB,击败了70.38% 的Java用户
     */
    public boolean repeatedSubstringPattern(String s) {
        int size = s.length();
        for (int i = 2; i <= size; i++) {
            if(size%i==0){
                String son = s.substring(0, size / i);
                StringBuilder b=new StringBuilder();
                for (int a=0;a<i;a++){
                    b.append(son);
                }
                if(b.toString().equals(s)){
                    return true;
                }
            }
        }
        return false;
    }

//    /**
//     * 超时
//     * @param s
//     * @return
//     */
//    public boolean repeatedSubstringPattern(String s) {
//        int size = s.length();
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = i + 1; j < s.length(); j++) {
//                if(size%(j-i)==0){
//                    String son = s.substring(i, j);
//                    if(s.replaceAll(son,"").length()==0){
//                        return true;
//                    }
//                }
//            }
//        }
//        return false;
//    }
//    /**
//     * 超时
//     * @param s
//     * @return
//     */
//    public boolean repeatedSubstringPattern(String s) {
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = i+1; j < s.length(); j++) {
//                String son = s.substring(i, j);
//                if(s.replaceAll(son,"").length()==0){
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    public static void main(String[] args) {
        System.out.println(new A459_DuplicateSubstring().repeatedSubstringPattern("bb"));
//        System.out.println(new A459_DuplicateSubstring().repeatedSubstringPattern("abcabcabcabc"));
//        System.out.println(new A459_DuplicateSubstring().repeatedSubstringPattern("qhcxrqiuxbwxrpydokcsgxwhwqdazloptqpmjzjgafftwdwkpacxzafxqkxsvmjqeadpbmvbtbupgsbysdvtecqwmqqiecaicdyervhkyebhwcfricmofdmttddxfehjhhnbdxnbbpiztpsdufrzkeudjycqcjzltpmwmczprkqmblqvqjwcnrfypjotuoenftlrvlioxycylsubcqfrhksyvgrqwyfbtruqecgbdibodvshoxaxksyhbrxxrfbkyvccaifftgtwendulfrxyrebjeaajbljzplzyseryzpenuyazszxldyujzvucidbxqcxiiqjifnxbozbiyatdzqpaljevpisfksovkxfqmctcdumdviiwyxwljcgykadvsrsdqxvfbojelwjgercerapacvypxdmqxevpbsucieitctbikdmdfdfkydzvjlngpkvqcsunyeiaxkijnwnvzsfzyewhpkpewmwbeqocwwetgmcwkrrjkwikahtrtivpurqbjgffdkalwcjjuasgydqamjrftmupfnqqtwxyixmgavpwwkewnuxbfqgyfankpgdjeajmavscrkypucnjykkdbqdgsssiyxteycsyalarxairevacikhlcktucnedlzhlcalennvknfdtadvkpevtoopqcutntdyxfjbsyyeldhggkdqbhmuvcjngfjtzmtyreclcappgyvmkyelfshcxqsdybxzpsxizzvbcktikowupcfwxozuerxeuudlpdtocorgakqkboeqrlmoznifghkacpltsghxwydyjwikkocdbqtcediklunpjaichpzfpeeaaomndoqgfkjlntvapkpalxeuodzekdgkstzxjqfqcqbrjzsajhbwhfqvlqbvvkhpdhoozufbkgswhmwruzpdfgysycpvmwlrfzfevkhitagaoctiejnlrodpqskeqxvwzccwpkekmkmapgltryeimjzeblirjfpkksgzeljqxvsmddhueleswdxxrhrapgmzasaeflwdippmuxiykpthssgjzzlqgxrisrnxelanaszxrjxdyqmtiteksqaapsljlahqljdodeluniamzmhhhltcduevopebpnrdzwrcaczqmzelnlvvwozakdvyvbakptpoqgqskrixqmkezfbwwaygfthauhnlcczsjsnvjvsakdgjkjhglfpqawrxfeijiietcrplmhnymvixepfpvwivuzsbfdlnnpjpgyaufotslbrqsyhpvpnpohrvkclxtumzsptzfmtqpkgkjqzefmvwumteqeejaskuheumsndkalulbtrhimfczyirdmdffnaotwbmlgyltsyvnpevclxdjiuowxudnwsgsvufdsrwkrtahzvjkvoudikbiefvaxduuyaxqtvdkpdtqacbvqxabhclohiqgllcjnzciwfulkockqfgjcimlkxztfqbsddeqeiybnsozgsjzzrkdawpmtqiaglujrabxibyxwpwejgfjxpmzlboguwiahfmafpyorylpnitxqzipoupcyfisbtukyildyjtrhhgxpzwhyewpanrasbstupguxtavevmncsktuiauoxjpkcpdekyazevyzxudsirvddoxmptaodryfhdltcmuijsigolaxevcimbwduwrzqrhxvssxgmhpgpxvdyujvwrhzpktmdvcvcbquvpbhwsposktsecncwxbljxznsdiugaqbprknmabekwwrzltxixiuwihonrkutaviuixgibkuxinythvcgewcofsbycxrctbydyelzqhzyvxsetwkzuonbgqziosmjvnmtrzvkiuidrcjkavlwjaxrrybhsqsndghwhegpyrvrvgcwcpsnqsfjqgqjykwbqfyzjeojxlbtsfpwujjkbqtuzldxxbznjxmuddedqhwioneiwqvygqufezdbacrlbfggkmjbvfjjsqtrgormhlulkxombfyengkxuwypdkyyarpiiiwptqcdnsrqypunxfkrdlggvggxaxhifdzyuddjvvcvkwikdvbggkpbqvyqvfaakzzgecsazuxmqgwwbxchhtkarkqmrrmbsnixsczrwwdoebkfzpoikyibkbpbuedmrnllpkfnjkbnmovnfjxpkitwjiydmdrgqdthpywyjzmvnhksshkepdbylbdaexiwabfrabqlaegqnskhzumpzpplqvnwsvsuwxlyabjchruujhclbqcbhtozobviypcwmoxoriqbanvluzyxpaawwovkrsvrhxotnnjhvcivpfjjfjgwkhtgxqsrjpiqnymclvlhxveobpxgzgclnxtmqndzdmrsmduybifadlpebomaurljoewerzfwnxoacjydrfeuqvbtjnteegnvmjbgljcygraicamvfspynsrwgnamvqjiblomuqlcjnkloygvsytfqneycglxwwfyhtkdmxhvlujbspwlnqsefwchdpezmmzvfkbtjirwcaxxpukfmcltznaefgdtsdqaprvacmxemubeoljcquvpjxvqeajwfcyutuvvgscvofzftkhjgdapavigvtdbvdxrxsmemqbbwaipmpysuyjxvtdqnitimrzllopyeqbasjrgapaxpmukfzdskwdynejzubzztcbmntunkvkahgmmgphsomqdqzcladmwfpisieivbuxibjxjbgbrstuiszvvchrkxbchhmejhbrinqrqwuhonbzhcuefexpdatkigptnskxfdqvzkeqzgpikjpppmgspadxiuqxmcuuhkphwuzxcofmzuepjkhymmxuiptxrnrbxikvcjsgzavyubpflzdanawwpqvjdmkduuazftfetcepdwvrvyrkbpisfdblpnqkjqlolsugvzwavtrstkeuannhqquigmupffgqxaxubvvyooqhzxebkrkcjhmptghynprnrohtlerztkishmvtffxpokgiqpiggztyparahkzaukudwpycwwtlgbvytdezfxxuaqvhbwjxgddfubjszcdffagygmalkzfmqavtzeqfjtmdxvvwxbefdmfjyfukhcwxctqdziliexlbtjzsmfxprfzqmvctxbqcuifurqcvqqyjzxbnfbcwidouzrowsgyopgiiyndoddxeabrhevgmzuiynywhfxywdggbvlsaopgqszyyvekuavuqtqxanxysgewbpocdfkwakuyfalbagvqblqcbnavvhrxyhbeplapvwncwydwgypimhmnwmksvcpulsyadapbwfdsdjqmhfutmgilutdqxumimmlrmauifyalhqxqytmmzuxtpalouzxilkaxkufsuhfdacwyvikwekrukfihehpqtrpeoxyiedoehkeesrcybtunyfudmmvgfkmthmcorsuaczewsiutbpgcudhircqwoeqyqumjogjqhpozxiubzddvikezowxebpctlqdzzmrgcfibqecrhhnrtrshnsoqhqkvhnwizoqdvahnflhotugmnawcsktccdxlstttjkxhkgwrrdgkzozmoxphjkllpizhduapgzwrfukzaslzgkoxjfgsprgezflezntgnrzumltoefnkpdhbiptzgzdhgqmighqtzpnnchbgmqrduaeesaeybjiiawqgdgbcxorzxuillbrhdxlvxpwzbejdazlfhmkgcbhcwpnjqequcdrbvncwrlztmkzvyjbaklciaqrtwhpangeiugensdhgpgcnrfnbqsktkdogndjalniftmvnrcuikyvbdkeueqnoubxhgghrvrzofueyyagiydlbppvuikicnhlvnsnklobqkfoifwsdzfgoueicotgearzqloawcbomgcwnyosztzoqdyutrbxsuzignicqkresvbgwravnzjdekzabaxvvwddmoheaaiuwlcuddpqebvjlwjmxiiuhnztdgzfhhaftczyhoqmrnxcjirisbezqduuktztdbywezwlnmzfzwjkgatzdxaubvolqpgtrerxdpksbmzckjnrlgqpdqjgnztgqzbjftgkktdmfeqppdgdlysrrdxgermuqogyjmithlhmsychdkkpleicjfinyxkrlqpuexpmlxydvcmapxradzcnfmafjmwwcnqhlityftdcypenownsvrfcdhipuglwuefhmahtwkxuzbhqxuivnnxquhhootnkxstlvaermblnesdcolxbawtvebluuagttbeqbihnlucpmgtcrsdupypvzcrvdxoyysobcxqprshfyahsvmmmkdhmhahkxykxsaavxqkokrvlucfpqtbbwkpfkyqjwcipdimaayrmsmxmredhxgkvqzbcytluvvlydxbfyurqirezvhjtptohtrjtkwngrbgwyjbwdsomjsnfbwaqqqxligeseravujrvsutynimyazdcwfsmwszeadyfwbarmumgofednqcqshuonoclgbrhepmasorgkfnblteamisesmshbwshxjqdaeftvzzfeogrinsuvkapzswaqojpxcuagzvbywhflpwveqpcdprcjoebepqcrkeyjzbkvkrganbggsiljapsqtvuilycxcajbdtxokfqzhwfbfslhhfxabtlmspkuptyuoxiacyzjxhlezylhdkjefwtxlfucyuxorhotipffysjyqwhtisynrtleyhhybgmspclxrseqknqalzuttuhknurlbajeixwxzjxscbkmrapcbjwvffhubyfcyqiinggopdgterivtxaviyspdbjecqicislxyrlpwtjaktygsadayvpdyajaqtdylovjhgydbjfoefuwfxwduniunrvfkydvoygvghykqfyvlstqrqwnfejvyeaieegsempntnxmvxjgrcwkuuzazivznxhtbpmicdxxrwjotsumvqwpnvrodonsmumpmaqhcxrqiuxbwxrpydokcsgxwhwqdazloptqpmjzjgafftwdwkpacxzafxqkxsvmjqeadpbmvbtbupgsbysdvtecqwmqqiecaicdyervhkyebhwcfricmofdmttddxfehjhhnbdxnbbpiztpsdufrzkeudjycqcjzltpmwmczprkqmblqvqjwcnrfypjotuoenftlrvlioxycylsubcqfrhksyvgrqwyfbtruqecgbdibodvshoxaxksyhbrxxrfbkyvccaifftgtwendulfrxyrebjeaajbljzplzyseryzpenuyazszxldyujzvucidbxqcxiiqjifnxbozbiyatdzqpaljevpisfksovkxfqmctcdumdviiwyxwljcgykadvsrsdqxvfbojelwjgercerapacvypxdmqxevpbsucieitctbikdmdfdfkydzvjlngpkvqcsunyeiaxkijnwnvzsfzyewhpkpewmwbeqocwwetgmcwkrrjkwikahtrtivpurqbjgffdkalwcjjuasgydqamjrftmupfnqqtwxyixmgavpwwkewnuxbfqgyfankpgdjeajmavscrkypucnjykkdbqdgsssiyxteycsyalarxairevacikhlcktucnedlzhlcalennvknfdtadvkpevtoopqcutntdyxfjbsyyeldhggkdqbhmuvcjngfjtzmtyreclcappgyvmkyelfshcxqsdybxzpsxizzvbcktikowupcfwxozuerxeuudlpdtocorgakqkboeqrlmoznifghkacpltsghxwydyjwikkocdbqtcediklunpjaichpzfpeeaaomndoqgfkjlntvapkpalxeuodzekdgkstzxjqfqcqbrjzsajhbwhfqvlqbvvkhpdhoozufbkgswhmwruzpdfgysycpvmwlrfzfevkhitagaoctiejnlrodpqskeqxvwzccwpkekmkmapgltryeimjzeblirjfpkksgzeljqxvsmddhueleswdxxrhrapgmzasaeflwdippmuxiykpthssgjzzlqgxrisrnxelanaszxrjxdyqmtiteksqaapsljlahqljdodeluniamzmhhhltcduevopebpnrdzwrcaczqmzelnlvvwozakdvyvbakptpoqgqskrixqmkezfbwwaygfthauhnlcczsjsnvjvsakdgjkjhglfpqawrxfeijiietcrplmhnymvixepfpvwivuzsbfdlnnpjpgyaufotslbrqsyhpvpnpohrvkclxtumzsptzfmtqpkgkjqzefmvwumteqeejaskuheumsndkalulbtrhimfczyirdmdffnaotwbmlgyltsyvnpevclxdjiuowxudnwsgsvufdsrwkrtahzvjkvoudikbiefvaxduuyaxqtvdkpdtqacbvqxabhclohiqgllcjnzciwfulkockqfgjcimlkxztfqbsddeqeiybnsozgsjzzrkdawpmtqiaglujrabxibyxwpwejgfjxpmzlboguwiahfmafpyorylpnitxqzipoupcyfisbtukyildyjtrhhgxpzwhyewpanrasbstupguxtavevmncsktuiauoxjpkcpdekyazevyzxudsirvddoxmptaodryfhdltcmuijsigolaxevcimbwduwrzqrhxvssxgmhpgpxvdyujvwrhzpktmdvcvcbquvpbhwsposktsecncwxbljxznsdiugaqbprknmabekwwrzltxixiuwihonrkutaviuixgibkuxinythvcgewcofsbycxrctbydyelzqhzyvxsetwkzuonbgqziosmjvnmtrzvkiuidrcjkavlwjaxrrybhsqsndghwhegpyrvrvgcwcpsnqsfjqgqjykwbqfyzjeojxlbtsfpwujjkbqtuzldxxbznjxmuddedqhwioneiwqvygqufezdbacrlbfggkmjbvfjjsqtrgormhlulkxombfyengkxuwypdkyyarpiiiwptqcdnsrqypunxfkrdlggvggxaxhifdzyuddjvvcvkwikdvbggkpbqvyqvfaakzzgecsazuxmqgwwbxchhtkarkqmrrmbsnixsczrwwdoebkfzpoikyibkbpbuedmrnllpkfnjkbnmovnfjxpkitwjiydmdrgqdthpywyjzmvnhksshkepdbylbdaexiwabfrabqlaegqnskhzumpzpplqvnwsvsuwxlyabjchruujhclbqcbhtozobviypcwmoxoriqbanvluzyxpaawwovkrsvrhxotnnjhvcivpfjjfjgwkhtgxqsrjpiqnymclvlhxveobpxgzgclnxtmqndzdmrsmduybifadlpebomaurljoewerzfwnxoacjydrfeuqvbtjnteegnvmjbgljcygraicamvfspynsrwgnamvqjiblomuqlcjnkloygvsytfqneycglxwwfyhtkdmxhvlujbspwlnqsefwchdpezmmzvfkbtjirwcaxxpukfmcltznaefgdtsdqaprvacmxemubeoljcquvpjxvqeajwfcyutuvvgscvofzftkhjgdapavigvtdbvdxrxsmemqbbwaipmpysuyjxvtdqnitimrzllopyeqbasjrgapaxpmukfzdskwdynejzubzztcbmntunkvkahgmmgphsomqdqzcladmwfpisieivbuxibjxjbgbrstuiszvvchrkxbchhmejhbrinqrqwuhonbzhcuefexpdatkigptnskxfdqvzkeqzgpikjpppmgspadxiuqxmcuuhkphwuzxcofmzuepjkhymmxuiptxrnrbxikvcjsgzavyubpflzdanawwpqvjdmkduuazftfetcepdwvrvyrkbpisfdblpnqkjqlolsugvzwavtrstkeuannhqquigmupffgqxaxubvvyooqhzxebkrkcjhmptghynprnrohtlerztkishmvtffxpokgiqpiggztyparahkzaukudwpycwwtlgbvytdezfxxuaqvhbwjxgddfubjszcdffagygmalkzfmqavtzeqfjtmdxvvwxbefdmfjyfukhcwxctqdziliexlbtjzsmfxprfzqmvctxbqcuifurqcvqqyjzxbnfbcwidouzrowsgyopgiiyndoddxeabrhevgmzuiynywhfxywdggbvlsaopgqszyyvekuavuqtqxanxysgewbpocdfkwakuyfalbagvqblqcbnavvhrxyhbeplapvwncwydwgypimhmnwmksvcpulsyadapbwfdsdjqmhfutmgilutdqxumimmlrmauifyalhqxqytmmzuxtpalouzxilkaxkufsuhfdacwyvikwekrukfihehpqtrpeoxyiedoehkeesrcybtunyfudmmvgfkmthmcorsuaczewsiutbpgcudhircqwoeqyqumjogjqhpozxiubzddvikezowxebpctlqdzzmrgcfibqecrhhnrtrshnsoqhqkvhnwizoqdvahnflhotugmnawcsktccdxlstttjkxhkgwrrdgkzozmoxphjkllpizhduapgzwrfukzaslzgkoxjfgsprgezflezntgnrzumltoefnkpdhbiptzgzdhgqmighqtzpnnchbgmqrduaeesaeybjiiawqgdgbcxorzxuillbrhdxlvxpwzbejdazlfhmkgcbhcwpnjqequcdrbvncwrlztmkzvyjbaklciaqrtwhpangeiugensdhgpgcnrfnbqsktkdogndjalniftmvnrcuikyvbdkeueqnoubxhgghrvrzofueyyagiydlbppvuikicnhlvnsnklobqkfoifwsdzfgoueicotgearzqloawcbomgcwnyosztzoqdyutrbxsuzignicqkresvbgwravnzjdekzabaxvvwddmoheaaiuwlcuddpqebvjlwjmxiiuhnztdgzfhhaftczyhoqmrnxcjirisbezqduuktztdbywezwlnmzfzwjkgatzdxaubvolqpgtrerxdpksbmzckjnrlgqpdqjgnztgqzbjftgkktdmfeqppdgdlysrrdxgermuqogyjmithlhmsychdkkpleicjfinyxkrlqpuexpmlxydvcmapxradzcnfmafjmwwcnqhlityftdcypenownsvrfcdhipuglwuefhmahtwkxuzbhqxuivnnxquhhootnkxstlvaermblnesdcolxbawtvebluuagttbeqbihnlucpmgtcrsdupypvzcrvdxoyysobcxqprshfyahsvmmmkdhmhahkxykxsaavxqkokrvlucfpqtbbwkpfkyqjwcipdimaayrmsmxmredhxgkvqzbcytluvvlydxbfyurqirezvhjtptohtrjtkwngrbgwyjbwdsomjsnfbwaqqqxligeseravujrvsutynimyazdcwfsmwszeadyfwbarmumgofednqcqshuonoclgbrhepmasorgkfnblteamisesmshbwshxjqdaeftvzzfeogrinsuvkapzswaqojpxcuagzvbywhflpwveqpcdprcjoebepqcrkeyjzbkvkrganbggsiljapsqtvuilycxcajbdtxokfqzhwfbfslhhfxabtlmspkuptyuoxiacyzjxhlezylhdkjefwtxlfucyuxorhotipffysjyqwhtisynrtleyhhybgmspclxrseqknqalzuttuhknurlbajeixwxzjxscbkmrapcbjwvffhubyfcyqiinggopdgterivtxaviyspdbjecqicislxyrlpwtjaktygsadayvpdyajaqtdylovjhgydbjfoefuwfxwduniunrvfkydvoygvghykqfyvlstqrqwnfejvyeaieegsempntnxmvxjgrcwkuuzaziv"));
    }
}
