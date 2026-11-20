/**
 * @param {string} s
 * @return {boolean}
 */
var checkValidString = function(s) {
    let minOpen = 0;
    let maxOpen = 0;

    for (const ch of s) {
        if (ch === '(') {
            minOpen++;
            maxOpen++;
        } else if (ch === ')') {
            minOpen--;
            maxOpen--;
        } else { // ch === '*'
            minOpen--; // treat '*' as ')'
            maxOpen++; // treat '*' as '('
        }

        // Even if every '*' became '(', there are still too many ')'
        if (maxOpen < 0) return false;

        // We can't have fewer than 0 open brackets (treat excess '*' as empty)
        if (minOpen < 0) minOpen = 0;
    }

    return minOpen === 0;
};