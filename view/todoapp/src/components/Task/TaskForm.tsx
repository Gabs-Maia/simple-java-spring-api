import React from 'react';
import Tag from '../Cards_Tags/Tag.tsx';
import "./TaskForm.css";
import TaskColumn from "./TaskColumn.tsx";

const TaskForm: React.FC = () => {

    return(
            <header className='app_header'>
                <form>
                    <input type="text" className="task_input" placeholder='Enter your task'/>
                    <div className='task_form_bottom_line'>
                       
                       <div>
                            <Tag tagName="Python" />
                            <Tag tagName='Java' />
                            <Tag tagName='Spring'/>
                            <Tag tagName='CSS' />

                        </div>
                        
                        <div> 
                            <select className='task_status'>
                                <TaskColumn />
                                <option value='doing'>Doing</option>
                                <option value='done'>Done</option>
                            </select>
                        </div>

                        <button type="submit" className='task_submit'>+ Add Task</button>
                    </div>       
                </form>
            </header>
        )
    }

export default TaskForm;