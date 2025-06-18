export function Buttom(props: React.ButtonHTMLAttributes<HTMLButtonElement>) {
    return (
        <button className='bg-red-600 p-2 w-10/12 rounded-2xl  text-white whitespace-nowrap' {...props}></button>
    );
}