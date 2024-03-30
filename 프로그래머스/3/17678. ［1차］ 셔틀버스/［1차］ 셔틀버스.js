function solution(n, t, m, timetable) {
    timetable.sort();
    const minuteTimetable=timetable.map(a=>{
        return a.split(":")[0]*60+a.split(":")[1]*1;
    });

    const makeTime=(time)=>{
        let fhour=Math.floor(time/60);
        let hour=(fhour+"").length===2?fhour+"":("0"+fhour);
        let minute=(time%60+"").length===2?time%60+"":("0"+time%60);
        return hour+":"+minute;
    }

    const makeAnswer=()=>{
        let idx=0,myTime=0;
        for(let i=0;i<n;i++){
            let arriveTime=540+i*t;
            let count=0;
            myTime=arriveTime;
            if(i<n-1){
                for(let j=idx;j<minuteTimetable.length;j++){
                    if(minuteTimetable[j]<=arriveTime){
                        idx++; count++;
                    }   
                    if(count===m) break;
                }
            }
            else{
                for(let j=idx;j<minuteTimetable.length;j++){
                    if(minuteTimetable[j]<=arriveTime) count++;
                    if(count===m){
                        myTime=minuteTimetable[j]-1;
                        break;
                    }
                }
            }
        }

        return myTime;
    }

    //minuteTimetable.sort();
    return makeTime(makeAnswer());
}