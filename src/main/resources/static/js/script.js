console.log("Script here");

let currentTheme = getTheme();
console.log("Current theme: " + currentTheme);
changeTheme();

function changeTheme() {
    //set to web page theme
    document.querySelector('html').classList.add(currentTheme);

    //set the listener to change theme button
    const changeThemeButton = document.querySelector('#theme_change_button');
    
   
    
    changeThemeButton.addEventListener("click", (event) => { 
        const oldTheme = currentTheme;

        


        //change the theme to the opposite of the current theme
        if (currentTheme == "dark") { currentTheme = "light" }
        else { currentTheme = "dark"; }

        //update the theme in localstorage
        setTheme(currentTheme);

        //remove the current theme
          document.querySelector('html').classList.remove(oldTheme);
        
        //change the theme of the web page
        document.querySelector('html').classList.add(currentTheme);
        
   //change the text wrt the current theme
        changeThemeButton.querySelector("span").textContent = currentTheme == 'light' ? 'Ameya!!' : 'Pajji!!!!';

    
    });
}

//set the theme to local storage
function setTheme(theme) {
    localStorage.setItem("theme", theme);
    
}

//get the theme from local storage
function getTheme() {
    let theme = localStorage.getItem("theme");
    if(theme) return theme;
   else return "light";
}