export function Nav( {children }: { children?: React.ReactNode }){
    return(
        <nav className="flex flex-1 h-full  flex-row bg-white justify-between">
            <div className="p-4 flex flex-col items-start justify-center w-2/12">
                <a href="#" className="text-4xl">Task<span className="text-red-600 font-sans text-4xl underline">GT</span></a> 
            </div>
            <div className="flex flex-row w-2/12 justify-evenly  items-center gap-1 mr-3">
                {children}
            </div>
        </nav>
    )
}