function solution(citations) {
    const min = Math.min(...citations);
        const max = Math.max(...citations);
        let over = 0;
        let hIndex;
        
        if (min >= citations.length) {
            hIndex = citations.length;
        } else {
            for(let i = min; i <= max; i++) {
                hIndex = i;
                citations.forEach(val => {
                    if(hIndex <= val) {
                        over++;
                    }
                });
    
                if (hIndex > over) {
                    hIndex--;
                    break;
                } else {
                    over = 0;
                }
            }
        }

        return hIndex;
}