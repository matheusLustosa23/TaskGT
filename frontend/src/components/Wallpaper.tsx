export function Wallpaper({image,title,text,width,highlightedText}:{image:string,title?:string,text?:string,width?:number,highlightedText?:string}){
    return(
            <div className='flex flex-1  flex-col justify-center items-center  gap-2'>
        
            {title ? <h1 className='text-3xl font-serif'> {title}{highlightedText?<span className='text-white font-bold underline'>{highlightedText}</span>:''}</h1>:<h1 className='text-3xl font-serif'>Welcome to <span className='text-red-600'>TaskGT</span></h1>}
           
            <p className='font-mono'>{text?text:'Your personal tasks here'}</p>
            <img src={image} width={width?width :320} alt="" />

        </div>
    )

}