import React from 'react';
import TaskForm from "./components/Task/TaskForm.tsx";
import TaskColumn from "./components/Task/TaskColumn.tsx";
import iconTodo from "./assets/todo.png";
import iconOngoing from "./assets/ongoing.png";
import iconDone from "./assets/done.png";

import "./App.css";


const App: React.FC = () => {

  return(

    <div className='app'>
      <TaskForm />
      <main className='app_main'>
        <TaskColumn title='To do' icon={iconTodo} />
        <TaskColumn title='Doing'icon={iconOngoing} />
        <TaskColumn title='Done' icon={iconDone} />    
      </main>
    </div>

  )
}

export default App; 