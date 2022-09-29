import React from "react";
import zxcvbn from 'zxcvbn';

const PasswordStrengthMethod =({password})=>{

    const testResult=zxcvbn(password);
    const num = testResult.score*100/4;

    const funcProgressColor = () =>{
        switch(testResult.score)
        {
            case 0:
            return `red`;
            case 1:
            return `yellow`;
            case 2:
            return `orange`;
                    
            case 3:
            return `green`; 
         
            default:
                return `green`;           


        }
    }

   



    const changePasswordColor = () =>(
        {
            width:` ${num}% `,
            background:funcProgressColor(),
            height:'8px'
            
         }
    )
    return(
  <div className="progress" style={{ height: '8px' }}>
     <div className="progress-bar" style={changePasswordColor()}>

     </div>
  </div>
    )
}

export default PasswordStrengthMethod