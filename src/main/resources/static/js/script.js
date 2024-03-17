const toggleForm = () => {
    const container = document.querySelector('.container');
    container.classList.toggle('active');
  };


  function loadClasses() {
    var mainDiv = document.getElementById('adminMain');
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            mainDiv.innerHTML = xhr.responseText;
        }
    };
    xhr.open('GET', '/classes', true);  // Adjust the URL based on your Spring Boot mapping
    xhr.send();
  }


  function loadTeachers() {
    var mainDiv = document.getElementById('adminMain');
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            mainDiv.innerHTML = xhr.responseText;
        }
    };
    xhr.open('GET', '/teachers' ,true);  // Adjust the URL based on your Spring Boot mapping
    xhr.send();
  }



  function loadSessions() {
    var mainDiv = document.getElementById('adminMain');
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            mainDiv.innerHTML = xhr.responseText;
        }
    };
    xhr.open('GET', '/sessions' ,true);  // Adjust the URL based on your Spring Boot mapping
    xhr.send();
  }


    function loadParents() {
      var mainDiv = document.getElementById('adminMain');
      var xhr = new XMLHttpRequest();
      xhr.onreadystatechange = function() {
          if (xhr.readyState == 4 && xhr.status == 200) {
              mainDiv.innerHTML = xhr.responseText;
          }
      };
      xhr.open('GET','/parents', true); 
      xhr.send();
}


function loadModules() {
  var mainDiv = document.getElementById('adminMain');
  var xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function() {
      if (xhr.readyState == 4 && xhr.status == 200) {
          mainDiv.innerHTML = xhr.responseText;
      }
  };
  xhr.open('GET','/modules', true); 
  xhr.send();
}

function loadStudents() {
  var mainDiv = document.getElementById('adminMain');
  var xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function() {
      if (xhr.readyState == 4 && xhr.status == 200) {
          mainDiv.innerHTML = xhr.responseText;
      }
  };
  xhr.open('GET','/students', true); 
  xhr.send();
}



function loaddiplomes() {
  var mainDiv = document.getElementById('adminMain');
  var xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function() {
      if (xhr.readyState == 4 && xhr.status == 200) {
          mainDiv.innerHTML = xhr.responseText;
      }
  };
  xhr.open('GET','/diplomas', true); 
  xhr.send();
}


function loadUsers() {
  var mainDiv = document.getElementById('adminMain');
  var xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function() {
      if (xhr.readyState == 4 && xhr.status == 200) {
          mainDiv.innerHTML = xhr.responseText;
      }
  };
  xhr.open('GET','/users', true); 
  xhr.send();
}



// function addParents() {
//   var mainDiv = document.getElementById('adminMain');
//   var xhr = new XMLHttpRequest();
//   xhr.onreadystatechange = function() {
//       if (xhr.readyState == 4 && xhr.status == 200) {
//           mainDiv.innerHTML = xhr.responseText;
//       }
//   };
//   xhr.open('GET','/parents/create', true);  
//   xhr.send();
// }


