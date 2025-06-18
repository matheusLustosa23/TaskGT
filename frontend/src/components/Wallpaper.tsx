export function Wallpaper(props: {image:string,title?:string,text?:string,width?:number}){
    return(
            <div className='flex flex-1  flex-col justify-center items-center  gap-2'>
        
            {props.title ? <h1 className='text-3xl font-serif'> {props.title }</h1>:<h1 className='text-3xl font-serif'>Welcome to <span className='text-red-600'>TaskGT</span></h1>}
           
            <p className='font-mono'>{props.text?props.text:'Your personal tasks here'}</p>
            <img src={props.image} width={props.width?props.width :320} alt="" />

        </div>
    )

}