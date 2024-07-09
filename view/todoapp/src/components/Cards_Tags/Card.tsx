import "./Card.css";
import Tag from "./Tag.tsx";
import deleteIcon from '/src/assets/delete.png';

const Card = () => {
    return(
        <article className='task_card'>
            <p className='task_text'>This is a sample text</p>

            <div className='task_card_bottom_line'>
                
                <div className='task_card_tags'>
                    <Tag tagName="HTML"/>
                    <Tag tagName="CSS" />
                </div>
                
                <div className='task_delete'>
                    <img src={deleteIcon} className='delete_icon' alt="" />
                </div>
            </div>
        </article>
    );
} 

export default Card;