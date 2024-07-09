import './TaskColumn.css';
import Card from "../Cards_Tags/Card.tsx";

const TaskColumn = (props:any) =>{

    return(
        <section className='task_column'>
                <h2 className='task_column'>
                    <img className="task_column_icon" src={props.icon} alt = '' />
                    {props.title}
                </h2>

                <Card />
            </section>
    );
}

export default TaskColumn;